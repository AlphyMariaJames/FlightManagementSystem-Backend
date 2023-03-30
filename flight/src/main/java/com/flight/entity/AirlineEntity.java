package com.flight.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airline_entity")
public class AirlineEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airlineID;
	//@NonBlank
	@Column
	private String airlineName;
	@Column
	private String contactNumber;
	@Column
	private Boolean isBlock;
	@Column
	String flightIDs = null;

	public AirlineEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirlineEntity(Integer airlineID, String airlineName, String contactNumber, Boolean isBlock,
			String flightIDs) {
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

	@Override
	public int hashCode() {
		return Objects.hash(airlineID, airlineName, contactNumber, flightIDs, isBlock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirlineEntity other = (AirlineEntity) obj;
		return Objects.equals(airlineID, other.airlineID) && Objects.equals(airlineName, other.airlineName)
				&& Objects.equals(contactNumber, other.contactNumber) && Objects.equals(flightIDs, other.flightIDs)
				&& Objects.equals(isBlock, other.isBlock);
	}

	@Override
	public String toString() {
		return "AirlineEntity [airlineID=" + airlineID + ", airlineName=" + airlineName + ", contactNumber="
				+ contactNumber + ", isBlock=" + isBlock + ", flightIDs=" + flightIDs + "]";
	}
	
}