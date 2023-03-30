package com.flight.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class ScheduleFlight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_flight_id")
	private Integer scheduleFlightId;

	@OneToOne(fetch = FetchType.EAGER)
	private FlightEntity flight;
	@Column(name = "available_seats")
	private Integer availableSeats;

	@Column
	private Integer price;
	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

	public ScheduleFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleFlight(Integer scheduleFlightId, FlightEntity flight, Integer availableSeats, Integer price,
			Schedule schedule) {
		super();
		this.scheduleFlightId = scheduleFlightId;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.price = price;
		this.schedule = schedule;
	}

	public Integer getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(Integer scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	public FlightEntity getFlight() {
		return flight;
	}

	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduleFlight [scheduleFlightId=" + scheduleFlightId + ", flight=" + flight + ", availableSeats="
				+ availableSeats + ", price=" + price + ", schedule=" + schedule + "]";
	}

}