package br.inf.ufes.pp2017_01;





import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.*;

public class Encrypt {

	private static byte[] readFile(String filename) throws IOException
	{
		File file = new File(filename);
	    InputStream is = new FileInputStream(file);
        long length = file.length();
        // creates array (assumes file length<Integer.MAX_VALUE)
        byte[] data = new byte[(int)length];
        int offset = 0; int count = 0;
        while ((offset < data.length) &&
        		(count=is.read(data, offset, data.length-offset)) >= 0) {
            offset += count;
        }
        is.close();
        return data;
	}

	private static void saveFile(String filename, byte[] data) throws IOException
	{
		FileOutputStream out = new FileOutputStream(filename);
	    out.write(data);
	    out.close();
	}

	public static void main(String[] args) {
		// args[0] È a chave a ser usada
		// args[1] È o nome do arquivo de entrada

    try {
			byte[] key = args[0].getBytes();
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

			SecretKeySpec keySpec = new SecretKeySpec(byteList.get(598), "Blowfish");

			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			byte [] message = readFile(args[1]);
			String msg = new String(message);
			System.out.println("message size (bytes) = "+message.length);
			System.out.println("message content (bytes) = "+msg);

			byte[] encrypted = cipher.doFinal(message);

			saveFile(args[1]+".cipher", encrypted);

		} catch (Exception e) {
			// don't try this at home
			e.printStackTrace();
		}
	}
}
