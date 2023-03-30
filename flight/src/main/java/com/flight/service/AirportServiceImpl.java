package com.flight.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.flight.entity.Airport;

@Service
public class AirportServiceImpl implements AirportService {

	@Override
	public Airport getAirports() {

		return new Airport(Arrays.asList(new String[] { "Mumbai", "Kochi", "New Delhi", "Kolkata", "Chennai" }));

	}

}