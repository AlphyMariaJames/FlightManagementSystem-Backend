package com.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_entity")
public class FlightEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightId;
	private String flightCode;
	private Integer totalSeats;
	private Boolean status;
	private String airlineCode;
	
	public FlightEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightEntity(Integer flightId, String flightCode, Integer totalSeats, Boolean status, String airlineCode) {
		super();
		this.flightId = flightId;
		this.flightCode = flightCode;
		this.totalSeats = totalSeats;
		this.status = status;
		this.airlineCode = airlineCode;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", flightCode=" + flightCode + ", totalSeats=" + totalSeats
				+ ", status=" + status + ", airlineCode=" + airlineCode + "]";
	}

}
