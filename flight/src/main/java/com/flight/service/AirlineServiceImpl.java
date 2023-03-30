package com.flight.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.flight.entity.Airline;

import com.flight.entity.AirlineEntity;

import com.flight.exceptions.RecordAlreadyPresentException;

import com.flight.exceptions.RecordNotFoundException;

import com.flight.repository.AirlineRepository;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	private AirlineRepository airlineRepository;

	@Override
	public ResponseEntity<?> saveAirline(Airline airline) {

		Optional<AirlineEntity> findByName = airlineRepository.findByAirlineName(airline.getAirlineName());
		AirlineEntity airlineEntity = new AirlineEntity(null, airline.getAirlineName(), airline.getContactNumber(),
				airline.getIsBlock(), airline.getFlightIDs());
		if (!findByName.isPresent()) {
			return new ResponseEntity<>(airlineRepository.save(airlineEntity), HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException(
					"Airline with name : " + airline.getAirlineName() + " already present");

	}

	@Override
	public AirlineEntity getAirline(Integer airlineId) {
		Optional<AirlineEntity> findById = airlineRepository.findById(airlineId);
		if (!findById.isPresent()) {
			throw new RecordNotFoundException("Airline with code: " + airlineId + " not exists");
		}
		return findById.get();
	}

	@Override
	public List<AirlineEntity> getAllAirline() {
		return airlineRepository.findAll();
	}

	@Override
	public AirlineEntity updateAirline(Airline airline, Integer airlineId) {
		Optional<AirlineEntity> findById = airlineRepository.findById(airlineId);
		AirlineEntity airlineEntity = new AirlineEntity(airlineId, airline.getAirlineName(), airline.getContactNumber(),
				airline.getIsBlock(), airline.getFlightIDs());
		if (findById.isPresent()) {
			airlineRepository.save(airlineEntity);
		} else
			throw new RecordNotFoundException("Airline with code: " + airlineId + " not exists");

		return airlineEntity;
	}

	@Override
	public String deleteAirline(Integer airlineId) {
		Optional<AirlineEntity> findById = airlineRepository.findById(airlineId);
		if (findById.isPresent()) {
			airlineRepository.deleteById(airlineId);
			return "Airline removed";
		} else
			throw new RecordNotFoundException("Airline with code: " + airlineId + " not exists");
	}

	@Override
	public AirlineEntity availablityAirline(Boolean isBlock, Integer airlineId) {
		Optional<AirlineEntity> findById = airlineRepository.findById(airlineId);
		AirlineEntity airlineEntity = findById.get();
		airlineEntity.setIsBlock(isBlock);
		if (findById.isPresent()) {
			airlineRepository.save(airlineEntity);
			return airlineRepository.save(airlineEntity);
		} else
			throw new RecordNotFoundException("Airline with code: " + airlineId + " not exists");
	}

	@Override
	public List<String> getAllAirlineNames() {
		List<String> airlineNames = new ArrayList<>();
		airlineRepository.findByIsBlock(false).forEach((k)->airlineNames.add(k.getAirlineName()));
		
		return airlineNames;
	}
}