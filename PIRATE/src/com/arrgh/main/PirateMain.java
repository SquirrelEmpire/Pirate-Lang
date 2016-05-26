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
		
		LinkedList<LinkedList<String>> list = PirateUtility.splitTokens(tokenizer, PirateUtility.readFile("tests/program.pirate"));
		
		for(LinkedList<String> n : list) {
			
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		
		new PirateMain();
	}
}