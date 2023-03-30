package com.flight.entity;

public enum Meal {
	
	VEG("VEG"), NON_VEG("NON_VEG");
	
	private String value;

	public String getValue() {
		return value;
	}

	private Meal(String value) {
		this.value = value;
	}

}
