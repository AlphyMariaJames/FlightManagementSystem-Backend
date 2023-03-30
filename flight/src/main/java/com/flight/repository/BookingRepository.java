package com.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.BookingRecord;

@Repository
public interface BookingRepository extends JpaRepository<BookingRecord, Long> {

	@Query("SELECT t FROM BookingRecord t WHERE t.emailId = ?1")
	List<BookingRecord> findByEmail(String emailId);

}