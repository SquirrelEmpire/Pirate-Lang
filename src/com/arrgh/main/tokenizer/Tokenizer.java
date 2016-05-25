package com.arrgh.main.tokenizer;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Token> tokens;

	public void initialize() {
		
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Token>();
	}

	public void add(String regex, int token) {

		tokenInfos.add(new TokenInfo(Pattern.compile("^(" + regex + ")"), token));
	}

	public void tokenize(String str) {

		String text = str.trim();
		tokens.clear();

		while (!text.equals("")) {

			boolean foundMatch = false;

			for (TokenInfo info : tokenInfos) {

				Matcher m = info.getRegex().matcher(text);

				if (m.find()) {

					if(m.group().equals("\n")) {
						
						System.out.println(m.group());
					}
					
					foundMatch = true;

					String tok = m.group().trim();
					text = m.replaceFirst("").trim();
				
					tokens.add(new Token(info.getToken(), tok));

					break;
				}
			}

			if (!foundMatch) {
			
				throw new IllegalStateException("Please remove this: " + text);
			}
		}
	}

	public LinkedList<Token> getTokens() {
		
		return tokens;
	}
}
