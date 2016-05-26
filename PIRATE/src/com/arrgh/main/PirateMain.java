package com.arrgh.main;

import java.util.LinkedList;

import com.arrgh.main.parser.PirateParser;
import com.arrgh.main.parser.operators.PirateOperatorDeclare;
import com.arrgh.main.program.PirateProgram;
import com.arrgh.main.tokenizer.Tokenizer;

public class PirateMain {

	private Tokenizer tokenizer;
	private PirateParser parser;
	private PirateProgram program;
	
	public PirateMain() {
		
		tokenizer = new Tokenizer();
		tokenizer.initialize();
		
		tokenizer.add("[0-9]+", 1);
		tokenizer.add("[.|,|;|*|+|-|!]", 2);
		tokenizer.add("[a-zA-Z][a-zA-Z0-9]*", 3);
		
		LinkedList<LinkedList<String>> list = PirateUtility.splitTokens(tokenizer, PirateUtility.readFile("tests/program.pirate"));
		
		for(LinkedList<String> n : list) {
			
			System.out.println(n);
		}
		
		program = new PirateProgram();
		program.initialize();
		
		parser = new PirateParser();
		parser.initialize();
		
		parser.addChecker(new PirateOperatorDeclare());
		parser.parse(program, list);
	}
	
	public static void main(String[] args) {
		
		new PirateMain();
	}
}