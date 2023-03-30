package com.flight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flight.entity.AirlineEntity;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Integer> {

	@Query("SELECT t FROM AirlineEntity t WHERE t.airlineName = ?1")
	Optional<AirlineEntity> findByAirlineName(String airlineName);

	List<AirlineEntity> findByIsBlock(boolean b);

}