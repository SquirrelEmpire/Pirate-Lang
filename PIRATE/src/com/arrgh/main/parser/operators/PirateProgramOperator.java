package com.arrgh.main.parser.operators;

import java.util.LinkedList;

import com.arrgh.main.program.PirateProgram;

public abstract class PirateProgramOperator {
	
	protected int minimumLength;
	
	public abstract boolean isAcceptable(LinkedList<String> line);
	public abstract void operate(PirateProgram program, LinkedList<String> line);
	
	public int getMinimumLength() {
		
		return minimumLength;
	}
	
	public void setMinimumLength(int minimumLength) {
		
		this.minimumLength = minimumLength;
	}
}