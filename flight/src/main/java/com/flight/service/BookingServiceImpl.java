package com.flight.service;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.ZoneId;

import java.time.ZonedDateTime;

import java.util.Date;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.flight.entity.BookingRecord;

import com.flight.entity.Discount;

import com.flight.entity.Passenger;

import com.flight.exceptions.RecordNotFoundException;

import com.flight.repository.BookingRepository;

import com.flight.repository.DiscountRepository;

@Service

public class BookingServiceImpl implements BookingService {

	@Autowired

	private BookingRepository bookingRepository;

	@Autowired

	private DiscountRepository discountRepository;

	/*
	 * 
	 * @Autowired private PassengerRepository passengerRepository;
	 * 
	 */

	@Override

	public ResponseEntity<?> createBooking(BookingRecord record) {

		Long pnrNo = ZonedDateTime.of(LocalDateTime.now(),

				ZoneId.systemDefault()).toInstant().toEpochMilli();

		record.setId(pnrNo);

		Double fare = record.getFare() * record.getNoOfPassengers();

		if (record.getDiscountCode() != null) {

			Discount discount = discountRepository.findByDiscountCode(record.getDiscountCode()).get();

			fare = fare - (fare * discount.getDiscountPercent()) / 100;

		}

		record.setFare(fare);

		Set<Passenger> passengers = record.getPassengers();

		passengers.forEach(passenger -> passenger.setBookingRecord(record));

		record.setBookingDate(new Date());

		return new ResponseEntity<BookingRecord>(bookingRepository.save(record), HttpStatus.OK);

	}

	@Override

	public List<BookingRecord> getHistory(String emailId) {

		// HistoryResponse resp = new HistoryResponse();

		List<BookingRecord> bookingList = null;

		try {

			bookingList = bookingRepository.findByEmail(emailId);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		return bookingList;

	}

	public BookingRecord getBooking(long id) {

		return bookingRepository.findById(new Long(id)).get();

	}

	/*
	 * 
	 * @Override public Booking getTicketDetails(String pnrNo) { // TODO
	 * 
	 * Auto-generated method stub Booking booking =
	 * 
	 * bookingRepository.findById(pnrNo).orElse(null);
	 *
	 * 
	 * 
	 * List<Passenger> passengers = passengerRepository.findByBookingId(pnrNo);
	 * 
	 * booking.setPassengers(passengers);
	 *
	 * 
	 * 
	 * return booking; }
	 * 
	 */

	@Override

	public BookingRecord cancelBooking(long id) throws RecordNotFoundException {

		BookingRecord deletedRecord = bookingRepository.findById(new Long(id)).get();

		if (deletedRecord != null && (deletedRecord.getFlightDate().minusDays(1).isAfter(LocalDate.now())))

			bookingRepository.deleteById(new Long(id));

		else

			throw new RecordNotFoundException("You may cancel the booking 24 hrs before only...");

		return deletedRecord;

	}

}