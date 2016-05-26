package com.arrgh.main.program.type;

import com.arrgh.main.program.PirateElement;

public class PirateVariableNumber extends PirateElement {

	private double value;
	
	public PirateVariableNumber(String key, PirateElementType type, double value) {

		this.key = key;
		this.type = type;
		this.value = value;
	}

	public double getValue() {
		
		return value;
	}

	public void setValue(double value) {
		
		this.value = value;
	}
}