package com.arrgh.main.tokenizer;

import java.util.regex.Pattern;

public class TokenInfo {

	private Pattern regex;
	private int token;

	public TokenInfo(Pattern regex, int token) {

		this.regex = regex;
		this.token = token;
	}

	public Pattern getRegex() {
		
		return regex;
	}

	public void setRegex(Pattern regex) {
		
		this.regex = regex;
	}

	public int getToken() {
		
		return token;
	}

	public void setToken(int token) {
		
		this.token = token;
	}
}