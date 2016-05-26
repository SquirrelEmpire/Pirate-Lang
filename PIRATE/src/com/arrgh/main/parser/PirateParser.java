package com.arrgh.main.parser;

import java.util.LinkedList;

import com.arrgh.main.parser.operators.PirateProgramOperator;
import com.arrgh.main.program.PirateProgram;

public class PirateParser {
	
	private LinkedList<PirateProgramOperator> checkers;
	
	public void initialize() {
		
		checkers = new LinkedList<PirateProgramOperator>();
	}
	
	// Sorts out the program and stuffs it into the program:
	public void parse(PirateProgram program, LinkedList<LinkedList<String>> lines) {
		
		for(LinkedList<String> line : lines) {
			
			for(PirateProgramOperator checker : checkers) {
				
				if(checker.isAcceptable(line)) {
					
					checker.operate(program, line);
				}
			}
		}
	}
	
	public void addChecker(PirateProgramOperator checker) {
		
		checkers.add(checker);
	}

	public LinkedList<PirateProgramOperator> getCheckers() {
		
		return checkers;
	}

	public void setCheckers(LinkedList<PirateProgramOperator> checkers) {
		
		this.checkers = checkers;
	}
}