package com.flight.controller;

import java.util.List;
import javax.validation.Valid;
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
import com.flight.entity.Schedule;
import com.flight.entity.ScheduleFlight;
import com.flight.exceptions.RecordNotFoundException;
import com.flight.service.AirportService;
import com.flight.service.FlightService;
import com.flight.service.ScheduleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
 
       @Autowired
       ScheduleService scheduleService;
 
       @Autowired
       AirportService airportService;
 
       @Autowired
       FlightService flightService;
 
       @PostMapping("/save/{flightId}")
       public ResponseEntity<?> addSchedule(@Valid @RequestBody ScheduleFlight scheduledFlight,
                    @PathVariable Integer flightId) {
             Schedule schedule = scheduledFlight.getSchedule();
       schedule.setScheduleID(scheduledFlight.getScheduleFlightId());
             /*
             * try { schedule.setSrcAirport(airportService.viewAirport(source)); } catch
             * (RecordNotFoundException e) { return new ResponseEntity("Airport Not Found",
             * HttpStatus.BAD_REQUEST); } try {
             * schedule.setDstnAirport(airportService.viewAirport(destination)); } catch
             * (RecordNotFoundException e) { return new ResponseEntity("Airport Not Found",
             * HttpStatus.BAD_REQUEST); }
             */
 
             // schedule.setDeptDateTime(departureTime);
             // schedule.setArrDateTime(arrivalTime);
             try {
             scheduledFlight.setFlight(flightService.getFlightbyId(flightId));
             } catch (RecordNotFoundException e1) {
                    return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
             }
             scheduledFlight.setSchedule(schedule);
       scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getTotalSeats());
             try {
                    return new ResponseEntity<ScheduleFlight>(scheduleService.addScheduledFlight(scheduledFlight),
                                 HttpStatus.OK);
             } catch (Exception e) {
                    return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
             }
 
       }
 
       @GetMapping("/getall")
       public ResponseEntity<?> viewAllSF() {
             return new ResponseEntity(scheduleService.viewAllScheduledFlights(), HttpStatus.OK);
       }
 
       @GetMapping("/getavailable")
       public ResponseEntity<?> getAvailableSchedules() {
             return new ResponseEntity<List<ScheduleFlight>>(scheduleService.viewAvailableFlights(), HttpStatus.OK);
       }
 
       @DeleteMapping("/delete/{scheduleFlightId}")
       public ResponseEntity<?> deleteSchedule(@PathVariable Integer scheduleFlightId) {
             return new ResponseEntity<ScheduleFlight>(scheduleService.deleteSchedule(scheduleFlightId), HttpStatus.OK);
       }
}