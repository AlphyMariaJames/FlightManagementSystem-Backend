package com.flight.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.flight.entity.ScheduleFlight;

import com.flight.repository.ScheduleFlightRepository;

import com.flight.repository.ScheduleRepository;

@Service

public class ScheduleServiceImpl implements ScheduleService {

	@Autowired

	ScheduleFlightRepository scheduleFlightRepository;

	@Autowired

	ScheduleRepository scheduleRepository;

	@Override

	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight) {

		// TODO Auto-generated method stub

		return scheduleFlightRepository.save(scheduledFlight);

	}

	@Override

	public Iterable<ScheduleFlight> viewAllScheduledFlights() {

		// TODO Auto-generated method stub

		return scheduleFlightRepository.findAll();

	}

	@Override

	public List<ScheduleFlight> viewAvailableFlights() {

		List<ScheduleFlight> allSchedule = scheduleFlightRepository.findAll();

		List<ScheduleFlight> avilableSchedule = new ArrayList<>();

		for (ScheduleFlight scheduledFlight : allSchedule) {

			if (scheduledFlight.getFlight().getStatus() == false) {

				avilableSchedule.add(scheduledFlight);

			}

		}

		return avilableSchedule;

	}

	@Override

	public ScheduleFlight deleteSchedule(Integer scheduleFlightId) {

		ScheduleFlight deletedRecord = scheduleFlightRepository.findById(scheduleFlightId).get();

		if (deletedRecord != null)

			scheduleFlightRepository.deleteById(scheduleFlightId);

		return deletedRecord;

	}

}