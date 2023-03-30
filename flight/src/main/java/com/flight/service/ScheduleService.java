package com.flight.service;

import java.util.List;

import com.flight.entity.ScheduleFlight;

public interface ScheduleService {

	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight);

	public Iterable<ScheduleFlight> viewAllScheduledFlights();

	public List<ScheduleFlight> viewAvailableFlights();

	public ScheduleFlight deleteSchedule(Integer scheduleFlightId);

}