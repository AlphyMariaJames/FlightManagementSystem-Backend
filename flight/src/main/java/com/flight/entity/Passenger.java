package com.flight.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "passenger_details")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	private String firstName;
	private String lastName;

	private String gender;
	private Meal meal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BOOKING_ID")
	@JsonIgnore
	private BookingRecord bookingRecord;

	public Passenger() {
	}

	public Passenger(long id, String firstName, String lastName, String gender, Meal meal,
			BookingRecord bookingRecord) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.meal = meal;
		this.bookingRecord = bookingRecord;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public BookingRecord getBookingRecord() {
		return bookingRecord;
	}

	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", meal=" + meal + ", bookingRecord=" + bookingRecord + "]";
	}

	
	
}
