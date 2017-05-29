package br.inf.ufes.pp2017_01;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.*;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.*;

public class Decrypt {

	private static byte[] readFile(String filename) throws IOException {

		File file = new File(filename);
		InputStream is = new FileInputStream(file);
		long length = file.length();

		  //creates array (assumes file length<Integer.MAX_VALUE)
		byte[] data = new byte[(int)length];

		int offset = 0;
		int count = 0;

		while((offset < data.length) && (count = is.read(data, offset, data.length-offset)) >= 0 ){
			offset += count;
		}
		is.close();
		return data;
	}

	private static void saveFile(String filename, byte[] data) throws IOException {

		FileOutputStream out = new FileOutputStream(filename);
		out.write(data);
		out.close();

	}


	public static void main(String[] args) {
		// args[0] e a chave a ser usada
		// args[1] e o nome do arquivo de entrada

		try {

			List<String> stringList = new ArrayList<String>();
			List<byte[]> byteList = new ArrayList<byte[]>();
			File file = new File("/home/rodgobbi/Documents/PP/trab1/dictionary.txt");
			if(file.exists()){
        stringList = Files.readAllLines(file.toPath(),Charset.defaultCharset());
    	}
			System.out.println("dic in string size = "+stringList.size());
			stringList.forEach( (string) -> {
				if (!string.contentEquals(""))
					byteList.add(string.getBytes());
			});
			System.out.println("dic in bytes size = "+byteList.size());
			byte[] key = args[0].getBytes();
			SecretKeySpec keySpec = new SecretKeySpec(byteList.get(598), "Blowfish");

			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, keySpec);

			byte[] message = readFile(args[1]);
			System.out.println("message size (bytes) = "+ message.length);

			byte[] decrypted = cipher.doFinal(message);
			String decString = new String(decrypted);
			if (decString.contains("tes"))
				System.out.println("message  = "+ decString);
			// saveFile(args[0]+".msg", decrypted);

		} catch (javax.crypto.BadPaddingException e) {
			// essa excecao e jogada quando a senha esta incorreta
			// porem nao quer dizer que a senha esta correta se nao jogar essa excecao
			System.out.println("Senha invalida.");

		} catch (Exception e) {
			//dont try this at home
			e.printStackTrace();
		}
	}

}
