package br.inf.ufes.pp2017_01;



/**
 * Guess.java
 */


import java.io.Serializable;

public class Guess implements Serializable {
	private String key;
	// chave candidata

	private byte[] message;
	// mensagem decriptografada com a chave candidata
	public Guess(String key, byte[] message) {
		this.key = key;
		this.message = message;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public byte[] getMessage() {
		return message;
	}
	public void setMessage(byte[] message) {
		this.message = message;
	}

}
