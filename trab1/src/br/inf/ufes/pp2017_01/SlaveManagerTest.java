package br.inf.ufes.pp2017_01;


public class SlaveManagerTest implements SlaveManager {
  @Override
   public void addSlave(Slave s, String slaveName, java.util.UUID slavekey)
           throws java.rmi.RemoteException {}
    @Override
   public void removeSlave(java.util.UUID slaveKey)
           throws java.rmi.RemoteException {}
    @Override
   public void foundGuess(java.util.UUID slaveKey, int attackNumber, long currentindex,
           Guess currentguess)
           throws java.rmi.RemoteException {}
  @Override
   public void checkpoint(java.util.UUID slaveKey, int attackNumber, long currentindex)
           throws java.rmi.RemoteException
           {System.out.println("slaveKey = "+slaveKey+"\nattackNumber = "+attackNumber+"\ncurrentindex = "+currentindex);}
}
