package com.flight.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import com.flight.entity.BookingRecord;
import com.flight.entity.Passenger;
import com.flight.entity.User;
import com.flight.exceptions.RecordNotFoundException;
import com.flight.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

@RequestMapping("/booking")

public class BookingController {

	@Autowired(required = true)

	BookingService bookingService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/save")
	// @ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<?> createBooking(@RequestBody BookingRecord bookingRecord) {

		/*
		 * User user = this.restTemplate.getForObject(http://USER-SERVICE/user/ +
		 * userName, User.class);
		 */

		return bookingService.createBooking(bookingRecord);

	}

	@GetMapping("/history/{email}")
	public ResponseEntity<?> bookingHistory(@PathVariable String email) {

		return new ResponseEntity(bookingService.getHistory(email), HttpStatus.OK);

	}

	@GetMapping("/ticket/{pnrNo}")
	public ResponseEntity<?> getTicketDetails(@PathVariable Long pnrNo) {

		return new ResponseEntity(bookingService.getBooking(pnrNo), HttpStatus.OK);

	}

	@DeleteMapping("/cancel/{pnrNo}")
	public BookingRecord getBooking(@PathVariable long pnrNo) {
		try {

			return bookingService.cancelBooking(pnrNo);
		} catch (RecordNotFoundException e) {
			return new BookingRecord(0, 0, null, null, null, null, null, null, null, null, null);
		}
	}

}