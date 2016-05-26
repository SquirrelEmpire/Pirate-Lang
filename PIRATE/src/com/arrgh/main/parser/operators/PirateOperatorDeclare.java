package com.arrgh.main.parser.operators;

import java.util.LinkedList;

import com.arrgh.main.program.PirateProgram;
import com.arrgh.main.program.type.PirateElementType;
import com.arrgh.main.program.type.PirateVariableNumber;

// I am indeed very sorry, but currently those have to be hard coded.
public class PirateOperatorDeclare extends PirateProgramOperator {
	
	public PirateOperatorDeclare() {
	
		minimumLength = 5;
	}
	
	@Override
	public boolean isAcceptable(LinkedList<String> line) {

		// ME NEW SWAG x BE <TYPE>!
		
		for(int i = 0; i < line.size(); i++) {
			
			if(line.size() >= minimumLength) {

				if(line.get(i).equals("ME") &&
						line.get(i + 1).equals("NEW") &&
						line.get(i + 2).equals("SWAG") &&
						line.get(i + 4).equals("BE")) {
	
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public void operate(PirateProgram program, LinkedList<String> line) {

		for(int i = 0; i < line.size(); i++) {
			
			if(line.get(i).equals("BE")) {
				
				if(line.get(i + 1).equals("NUMBER")) {
					
					program.addElement(line.get(i - 1), new PirateVariableNumber(line.get(i - 1), PirateElementType.VAR_NUMBER, 0));
				}
			}
		}
	}
}