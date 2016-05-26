package com.arrgh.main;

import java.util.LinkedList;

import com.arrgh.main.tokenizer.Token;
import com.arrgh.main.tokenizer.Tokenizer;

public class PirateMain {

	private Tokenizer tokenizer;
	
	public PirateMain() {
		
		tokenizer = new Tokenizer();
		tokenizer.initialize();
		
		tokenizer.add("[0-9]+", 3);
		tokenizer.add("[.|,|;|*|+|-|!]", 4);
		tokenizer.add("[a-zA-Z0-9]*", 5);
		
		LinkedList<LinkedList<String>> list = splitTokens(PirateUtility.readFile("tests/program.pirate"));
		
		for(LinkedList<String> n : list) {
			
			System.out.println(n);
		}
	}
	
	public LinkedList<LinkedList<String>> splitTokens(String text) {
		
		LinkedList<LinkedList<String>> tokens = new LinkedList<LinkedList<String>>();
		
		for(String line : text.split("\n")) {
			
			try {
				
				LinkedList<String> tempLine = new LinkedList<String>();
				
				tokenizer.tokenize(line);

				for (Token tok : tokenizer.getTokens()) {
					
					tempLine.add(tok.getSequence());
				}
				
				tokens.add(tempLine);
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		return tokens;
	}
	
	public static void main(String[] args) {
		
		new PirateMain();
	}
}
