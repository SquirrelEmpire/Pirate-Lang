package com.arrgh.main.program;

import com.arrgh.main.program.type.PirateElementType;

public abstract class PirateElement {

	protected PirateElementType type;
	protected String key;
	
	public PirateElementType getType() {
		
		return type;
	}

	public void setType(PirateElementType type) {
		
		this.type = type;
	}
	
	public String getKey() {
		
		return key;
	}

	public void setKey(String key) {
		
		this.key = key;
	}
}