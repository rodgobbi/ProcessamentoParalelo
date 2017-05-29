package br.inf.ufes.pp2017_01;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.rmi.RemoteException;

public class SlaveImpl implements Slave {
  private java.util.UUID slaveKey = java.util.UUID.randomUUID();
  private Dictionary dictionary = new Dictionary();
  public Dictionary getDictionary() {
    return dictionary;
  }
  public SlaveImpl(String dictionaryPath) throws IOException {
    dictionary.loadDictionary(dictionaryPath);
  }

  private ExecutorService executor = Executors.newFixedThreadPool(2);
  private long currentWordIndex;

  private class Checkpointer implements Runnable {
    private long finalWordIndex;
    private int attackNumber;
    private SlaveManager slaveManager;
    public Checkpointer(long finalwordindex, int attackNumber, SlaveManager callbackinterface) {
      this.finalWordIndex = finalwordindex;
      this.attackNumber = attackNumber;
      this.slaveManager = callbackinterface;
    }
    @Override
    public void run() {
      long localCurrentWordIndex;
      synchronized(this) {
        localCurrentWordIndex = currentWordIndex;
      }
      while(localCurrentWordIndex < finalWordIndex) {
        try {
          slaveManager.checkpoint(slaveKey, attackNumber, localCurrentWordIndex);
          Thread.sleep(2000); // TODO: make it 10000
        } catch(RemoteException e) {
          // TODO: abortar thread
        }
        catch (Exception e) {}
        synchronized(this) {
          localCurrentWordIndex = currentWordIndex;
        }
      }
    }
  }

  public void startSubAttack(
			byte[] ciphertext,
			byte[] knowntext,
			long initialwordindex,
			long finalwordindex,
			int attackNumber,
			SlaveManager callbackinterface) throws java.rmi.RemoteException
  {
    executor.execute(new Checkpointer(finalwordindex, attackNumber, callbackinterface));
  }
}
