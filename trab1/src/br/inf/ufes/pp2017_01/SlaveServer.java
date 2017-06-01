package br.inf.ufes.pp2017_01;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;

public class SlaveServer {
  public static void main(String[] args) {
		// args[0] eh o caminho para arquivo do dicionario

		try {
      SlaveManager slaveManagerTest = new SlaveManagerTest();
      String string = "caceta";
      SlaveImpl slave = new SlaveImpl(args[0]);
      int size = slave.getDictionary().getWordList().size();
			SecretKeySpec keySpec = new SecretKeySpec(slave.getDictionary().getWordList().get(size - 6), "Blowfish");

			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			byte [] message = (new String("Esse eh um teste de criptografia menasgem testeeeeeeeeeeeeeeeeeeeee TENSO muito tensooooooooooooooooooo iaa caceta\n toma paragrago\n vai toma sua gostosa"+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa "+
      " Esse eh um teste de criptografia menasgefq7ftuy3gr8173t3h iry8fg98uo4i2t908uyf982y13r987yf987213yhf7yfv298fyh2iy8f3892  aaaaaaaaatetetetetensssaaaa"+
      " Esse e&*%*%&Y*(&GH*&T*&%^^&^R&^U^&^R&^R^&Ryiuygvuaygva86969-89-08-08-08ihoiuc98y3u2hr890y3ui2h98hdf893rBKUUIHIPOH:OJPUJLIHYHP{O{}O:JOIHUYFHAHAUSY   aaaaaaaaaaaaa ")).getBytes();

			byte[] encrypted = cipher.doFinal(message);

      slave.startSubAttack(encrypted, string.getBytes(), 0, size - 1, 2020, slaveManagerTest);
		} catch (Exception e) {
			//dont try this at home
			e.printStackTrace();
		}
	}
}
