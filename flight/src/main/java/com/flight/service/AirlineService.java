package com.flight.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.flight.entity.Airline;
import com.flight.entity.AirlineEntity;

public interface AirlineService {

	public ResponseEntity<?> saveAirline(Airline airline);

	public AirlineEntity getAirline(Integer airlineId);

	public List<AirlineEntity> getAllAirline();

	public AirlineEntity updateAirline(Airline airline, Integer airlineId);

	public String deleteAirline(Integer airlineId);

	public AirlineEntity availablityAirline(Boolean isBlock, Integer airlineId);
	
	public List<String> getAllAirlineNames();

}