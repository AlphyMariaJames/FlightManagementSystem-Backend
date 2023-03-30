package com.flight.entity;

import java.util.List;

public class Airport {
	
	List<String> airports;

	public List<String> getAirports() {
		return airports;
	}

	public void setAirports(List<String> airports) {
		this.airports = airports;
	}

	public Airport(List<String> airports) {
		super();
		this.airports = airports;
	}
	
}
