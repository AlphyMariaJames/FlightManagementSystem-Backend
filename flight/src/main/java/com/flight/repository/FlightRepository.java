package com.flight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.flight.entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {

	@Query("SELECT t FROM FlightEntity t WHERE t.flightCode = ?1")
	Optional<FlightEntity> findByFlightName(String flightCode);

	@Modifying
	@Query("delete from FlightEntity b where b.flightCode=:flightCode")
	void deleteByFlightName(@Param("flightCode") String flightCode);

}