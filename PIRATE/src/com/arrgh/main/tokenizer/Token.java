package com.arrgh.main.tokenizer;

public class Token {

	private int token;
	private String sequence;

	public Token(int token, String sequence) {
		
		this.token = token;
		this.sequence = sequence;
	}

	public int getToken() {
		
		return token;
	}

	public void setToken(int token) {
		
		this.token = token;
	}

	public String getSequence() {
		
		return sequence;
	}

	public void setSequence(String sequence) {
		
		this.sequence = sequence;
	}
}