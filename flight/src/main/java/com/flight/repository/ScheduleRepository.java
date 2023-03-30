package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.flight.entity.Schedule;

@Repository

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}