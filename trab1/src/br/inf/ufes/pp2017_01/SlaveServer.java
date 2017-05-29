package br.inf.ufes.pp2017_01;

public class SlaveServer {
  public static void main(String[] args) {
		// args[0] eh o caminho para arquivo do dicionario

		try {
      SlaveManager sm = new SlaveManagerTest();
      String string = "00000";
      SlaveImpl slave = new SlaveImpl(args[0]);
      System.out.println("message size (bytes) = "+ slave.getDictionary().getWordList().size());
      slave.startSubAttack(string.getBytes(), string.getBytes(), 0, 10, 2020, sm);
		} catch (Exception e) {
			//dont try this at home
			e.printStackTrace();
		}
	}
}
