package com.flight.service;

import java.util.List;

import com.flight.entity.FlightEntity;

public interface FlightService {

	public FlightEntity saveFlight(FlightEntity flightEntity);

	public FlightEntity updateFlight(FlightEntity flightEntity, Integer flightId);

	public FlightEntity getFlight(String flightCode);

	public FlightEntity getFlightbyId(Integer flightId);

	public List<FlightEntity> getAllFlights();

	public String deleteFlight(Integer flightId);

	public FlightEntity searchFlight(String airlineCode, String flightCode);

}