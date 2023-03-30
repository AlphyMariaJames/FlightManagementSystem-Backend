package com.flight.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.flight.entity.FlightEntity;

import com.flight.service.FlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("/getallflights")
	public ResponseEntity<?> getFlight() {
		ResponseEntity<List<FlightEntity>> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			responseEntity = new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		// return new ResponseEntity<>("SignIn failed", HttpStatus.OK);
	}

	@GetMapping("/getflight/{flightCode}")
	public ResponseEntity<?> getFlight(@PathVariable String flightCode) {
		ResponseEntity<FlightEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			responseEntity = new ResponseEntity<>(flightService.getFlight(flightCode), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		// return new ResponseEntity<>("SignIn failed", HttpStatus.OK);
	}

	@GetMapping("/getflightbyid/{flightId}")
	public ResponseEntity<?> getFlightbyId(@PathVariable Integer flightId) {
		ResponseEntity<FlightEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			responseEntity = new ResponseEntity<>(flightService.getFlightbyId(flightId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		// return new ResponseEntity<>("SignIn failed", HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveFlight(@RequestBody FlightEntity flightEntity) {

		ResponseEntity<FlightEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {

			responseEntity = new ResponseEntity<>(flightService.saveFlight(flightEntity), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@PutMapping("/update/{flightId}")
	public ResponseEntity<?> updateFlight(@RequestBody FlightEntity flightEntity, @PathVariable Integer flightId) {

		ResponseEntity<FlightEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			responseEntity = new ResponseEntity<>(flightService.updateFlight(flightEntity, flightId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

//search API
	@GetMapping("/search/")
	public ResponseEntity<?> updateFlight(@QueryParam("airlineID") String airlineCode,
			@QueryParam("flightId") String flightCode) {

		ResponseEntity<FlightEntity> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			responseEntity = new ResponseEntity<>(flightService.searchFlight(airlineCode, flightCode), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@DeleteMapping("/delete/{flightId}")
	public ResponseEntity<?> deleteFlight(@PathVariable Integer flightId) {

		return new ResponseEntity<>(flightService.deleteFlight(flightId), HttpStatus.OK);

	}

}