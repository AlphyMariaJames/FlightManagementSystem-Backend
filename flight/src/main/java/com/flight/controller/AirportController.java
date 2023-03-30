package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.flight.entity.Airport;

import com.flight.service.AirportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/airport")
public class AirportController {

 

              @Autowired

              private AirportService airportService;

 

              @GetMapping("")

              public ResponseEntity<?> getFlight() {

                             ResponseEntity<Airport> responseEntity = new ResponseEntity<>(HttpStatus.OK);

                             try {

                                           responseEntity = new ResponseEntity<>(airportService.getAirports(), HttpStatus.OK);

                             } catch (Exception e) {

                                           e.printStackTrace();

                                           responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

                             }

                             return responseEntity;

                             // return new ResponseEntity<>("SignIn failed", HttpStatus.OK);

              }

 

}