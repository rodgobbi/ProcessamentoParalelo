package br.inf.ufes.pp2017_01;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.rmi.RemoteException;
import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class SlaveImpl implements Slave {
  private java.util.UUID slaveKey = java.util.UUID.randomUUID();
  private Dictionary dictionary = new Dictionary();
  public Dictionary getDictionary() {
    return dictionary;
  }
  public SlaveImpl(String dictionaryPath) throws IOException {
    dictionary.loadDictionary(dictionaryPath);
  }

  private ExecutorService executor = Executors.newFixedThreadPool(10);

  private class Checkpointer implements Runnable {
    private long finalWordIndex;
    private int attackNumber;
    private SlaveManager slaveManager;
    private Decrypter decrypter;
    public Checkpointer(long finalwordindex, int attackNumber, SlaveManager callbackinterface, Decrypter decrypter) {
      this.finalWordIndex = finalwordindex;
      this.attackNumber = attackNumber;
      this.slaveManager = callbackinterface;
      this.decrypter = decrypter;
    }
    @Override
    public void run() {
      long localLastUsedWordIndex = decrypter.getLastUsedWordIndex();
      try {
        while (true) {
          localLastUsedWordIndex = decrypter.getLastUsedWordIndex();
          if (localLastUsedWordIndex >= 0) {
            slaveManager.checkpoint(slaveKey, attackNumber, localLastUsedWordIndex);
          }
          if (localLastUsedWordIndex >= finalWordIndex) {
            break;
          }
          Thread.sleep(10000);
        }
      } catch (Exception e) {}
    }
  }
  private class Decrypter implements Runnable {
    private long lastUsedWordIndex = -1;
		private	byte[] cipherText;
		private	byte[] knownText;
		private	long initialWordIndex;
		private	long finalWordIndex;
		private	int attackNumber;
		private	SlaveManager slaveManager;
    public long getLastUsedWordIndex() {
      return lastUsedWordIndex;
    }
    public Decrypter(byte[] ciphertext, byte[] knowntext, long initialwordindex, long finalwordindex, int attackNumber, SlaveManager callbackinterface) {
      this.cipherText = ciphertext;
      this.knownText = knowntext;
      this.initialWordIndex = initialwordindex;
      this.finalWordIndex = finalwordindex;
      this.attackNumber = attackNumber;
      this.slaveManager = callbackinterface;
    }
    @Override
    public void run() {
      try {
        while (lastUsedWordIndex < finalWordIndex) {
          try {
            byte[] key = dictionary.getWordList().get((int) (lastUsedWordIndex >= 0 ? lastUsedWordIndex + 1 : initialWordIndex));
            SecretKeySpec keySpec = new SecretKeySpec(key, "Blowfish");
      			Cipher cipher = Cipher.getInstance("Blowfish");
      			cipher.init(Cipher.DECRYPT_MODE, keySpec);
      			byte[] decryptedMessage = cipher.doFinal(cipherText);
      			String decryptedString = new String(decryptedMessage);
      			if (decryptedString.contains(new String(knownText))) {
              slaveManager.foundGuess(slaveKey, attackNumber, lastUsedWordIndex >= 0 ? lastUsedWordIndex + 1 : initialWordIndex, new Guess(new String(key), decryptedMessage));
            }
          } catch (javax.crypto.BadPaddingException e) {}
          lastUsedWordIndex = lastUsedWordIndex >= 0 ? lastUsedWordIndex + 1 : initialWordIndex;
        }
      } catch (Exception e) {}
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
    Decrypter decrypter = new Decrypter(ciphertext, knowntext, initialwordindex, finalwordindex, attackNumber, callbackinterface);
    executor.execute(decrypter);
    executor.execute(new Checkpointer(finalwordindex, attackNumber, callbackinterface, decrypter));
    executor.shutdown();
  }
}
