package com.flight.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.flight.entity.BookingRecord;
import com.flight.exceptions.RecordNotFoundException;

public interface BookingService {

	public ResponseEntity<?> createBooking(BookingRecord newBooking);

	public List<BookingRecord> getHistory(String emailId);

	public BookingRecord getBooking(long id);

	public BookingRecord cancelBooking(long id) throws RecordNotFoundException ;

}