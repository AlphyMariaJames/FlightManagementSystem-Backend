package com.flight.service;

import java.util.List;

import java.util.Optional;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.flight.entity.AirlineEntity;

import com.flight.entity.FlightEntity;

import com.flight.exceptions.RecordAlreadyPresentException;

import com.flight.exceptions.RecordNotFoundException;

import com.flight.repository.AirlineRepository;

import com.flight.repository.FlightRepository;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private AirlineRepository airlineRepository;

	@Override
	public FlightEntity saveFlight(FlightEntity flightEntity) {

		Optional<FlightEntity> findByName = flightRepository.findByFlightName(flightEntity.getFlightCode());

		AirlineEntity airlineFlight = airlineRepository.findAll().stream()

				.filter((airline) -> airline.getAirlineName().equals(flightEntity.getAirlineCode()))

				.collect(Collectors.toList()).get(0);

		if (!findByName.isPresent()) {

			if (airlineFlight != null) {

				FlightEntity savedEntity = flightRepository.save(flightEntity);

				String flightIDs = airlineFlight.getFlightIDs();

				if (airlineFlight.getFlightIDs() != null && airlineFlight.getFlightIDs().length() > 0)

					airlineFlight.setFlightIDs(flightIDs + "," + savedEntity.getFlightCode());

				else

					airlineFlight.setFlightIDs(savedEntity.getFlightCode());

				airlineRepository.save(airlineFlight);

				return savedEntity;

			} else {

				throw new RecordNotFoundException(

						"Airline with code: " + flightEntity.getAirlineCode() + " not exists");

			}

		} else

			throw new RecordAlreadyPresentException(

					"Flight with code : " + flightEntity.getFlightCode() + " already present");

	}

	@Override
	public FlightEntity updateFlight(FlightEntity flightEntity, Integer flightId) {

		FlightEntity flight = flightRepository.findById(flightId).get();

		if (flight != null) {

			// flight.setFlightCode(flightEntity.getFlightCode());

			// flight.setAirlineCode(flightEntity.getAirlineCode());

			// flight.setPrice(flightEntity.getPrice());

			flight.setStatus(flightEntity.getStatus());

			flight.setTotalSeats(flightEntity.getTotalSeats());

			return flightRepository.save(flight);

		} else {

			throw new RecordNotFoundException(

					"Flight with id: " + flightEntity.getFlightId() + " not exists");

		}

	}

	@Override
	public FlightEntity getFlight(String flightCode) {

		return flightRepository.findByFlightName(flightCode).get();

	}

	@Override
	public List<FlightEntity> getAllFlights() {

		return flightRepository.findAll();

	}

	@Override

	public String deleteFlight(Integer flightId) {

		// Optional<FlightEntity> findByName =
		// flightRepository.findByFlightName(flightCode);

		Optional<FlightEntity> findByName = flightRepository.findById(flightId);
		FlightEntity flight = findByName.get();

		AirlineEntity airlineFlight = airlineRepository.findAll().stream()

				.filter((airline) -> airline.getAirlineName().equals(flight.getAirlineCode()))

				.collect(Collectors.toList()).get(0);

		if (findByName.isPresent()) {

			if (airlineFlight != null) {

				flightRepository.deleteByFlightName(flight.getFlightCode());

				String flightIDs = airlineFlight.getFlightIDs();
				if (airlineFlight.getFlightIDs().contains("," + flight.getFlightCode())) {

					airlineFlight.setFlightIDs(flightIDs.replace("," + flight.getFlightCode(), ""));
					
				}else if(airlineFlight.getFlightIDs().contains(flight.getFlightCode() + ",")){
					airlineFlight.setFlightIDs(flightIDs.replace(flight.getFlightCode() + ",", ""));
				}else if(airlineFlight.getFlightIDs().contains(flight.getFlightCode())){
					airlineFlight.setFlightIDs(flightIDs.replace(flight.getFlightCode(), ""));
				}

				airlineRepository.save(airlineFlight);

				return "Flight deleted";

			} else {

				throw new RecordNotFoundException(

						"Flight with airline code: " + flight.getAirlineCode() + " not exists");

			}

		} else

			throw new RecordAlreadyPresentException(

					"Flight with code : " + flight.getFlightCode() + " already present");

	}

	@Override
	public FlightEntity searchFlight(String airlineCode, String flightCode) {

		Optional<AirlineEntity> findByName = airlineRepository.findByAirlineName(airlineCode);

		if (findByName.isPresent()) {

			Optional<FlightEntity> findByNameFlight = flightRepository.findByFlightName(flightCode);

			if (!findByNameFlight.isPresent()) {

				return findByNameFlight.get();

			} else {

				throw new RecordNotFoundException(

						"Flight with code : " + findByNameFlight.get().getFlightCode() + " not exists");

			}

		} else {

			throw new RecordNotFoundException(

					"Airline with code: " + findByName.get().getAirlineName() + " not exists");

		}

	}

	@Override
	public FlightEntity getFlightbyId(Integer flightId) {

		return flightRepository.findById(flightId).get();

	}

}