package com.flight.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class BookingRecord {

	@Id
	long id;
	@Column
	private Integer flightId;
	@Column
	private String origin;
	@Column
	private String destination;
	@Column
	private LocalDate flightDate;
	@Column
	private Date bookingDate;
	@Column
	private Double fare;
	@Column
	private Integer noOfPassengers;
	@Column
	private String emailId;
	@Column
	private String discountCode;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bookingRecord")
	Set<Passenger> passengers;

	public BookingRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingRecord(long id, Integer flightId, String origin, String destination, LocalDate flightDate,
			Date bookingDate, Double fare, Integer noOfPassengers, String emailId, String discountCode,
			Set<Passenger> passengers) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.bookingDate = bookingDate;
		this.fare = fare;
		this.noOfPassengers = noOfPassengers;
		this.emailId = emailId;
		this.discountCode = discountCode;
		this.passengers = passengers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "BookingRecord [id=" + id + ", flightId=" + flightId + ", origin=" + origin + ", destination="
				+ destination + ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", fare=" + fare
				+ ", noOfPassengers=" + noOfPassengers + ", emailId=" + emailId + ", discountCode=" + discountCode
				+ ", passengers=" + passengers + "]";
	}

}
