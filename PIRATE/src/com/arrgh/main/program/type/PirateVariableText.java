package com.arrgh.main.program.type;

import com.arrgh.main.program.PirateElement;

public class PirateVariableText extends PirateElement {

	private String value;
	
	public PirateVariableText(PirateElementType type, String value) {

		this.type = type;
		this.value = value;
	}

	public String getValue() {
		
		return value;
	}

	public void setValue(String value) {
		
		this.value = value;
	}
}