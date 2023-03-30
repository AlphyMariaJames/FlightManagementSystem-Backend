package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.flight.entity.ScheduleFlight;

@Repository

public interface ScheduleFlightRepository extends JpaRepository<ScheduleFlight, Integer> {

}