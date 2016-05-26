package com.arrgh.main.program;

import java.util.HashMap;

import com.arrgh.main.program.type.PirateElementType;
import com.arrgh.main.program.type.PirateVariableNumber;

//	PirateProgram is currently handling every element of the
//	program file. This includes variables, methods and pirate ships.
public class PirateProgram {
	
	// Tell them from each other by PirateElementTypes ...
	private HashMap<String, PirateElement> elements;
	
	public void initialize() {
		
		elements = new HashMap<String, PirateElement>();
	}

	public void addElement(String key, PirateElement element) {
		
		elements.put(key, element);
		
		if(element.getType().equals(PirateElementType.VAR_NUMBER)) {

			System.out.println("NUMBER " + key + "=" + ((PirateVariableNumber)element).getValue());
		}
	}
}