package com.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Airline {
	@JsonIgnore
	private Integer airlineID;
	//@NonBlank
	private String airlineName;
	private String contactNumber;
	private Boolean isBlock;
	
	private String flightIDs;
	
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airline(Integer airlineID, String airlineName, String contactNumber, Boolean isBlock, String flightIDs) {
		super();
		this.airlineID = airlineID;
		this.airlineName = airlineName;
		this.contactNumber = contactNumber;
		this.isBlock = isBlock;
		this.flightIDs = flightIDs;
	}
	public Integer getAirlineID() {
		return airlineID;
	}
	public void setAirlineID(Integer airlineID) {
		this.airlineID = airlineID;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Boolean getIsBlock() {
		return isBlock;
	}
	public void setIsBlock(Boolean isBlock) {
		this.isBlock = isBlock;
	}
	public String getFlightIDs() {
		return flightIDs;
	}
	public void setFlightIDs(String flightIDs) {
		this.flightIDs = flightIDs;
	}
	
}
