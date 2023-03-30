package com.flight.controller;

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

import com.flight.entity.Discount;

import com.flight.service.DiscountService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

@RequestMapping("/discount")

public class DiscountController {

 

              @Autowired

              private DiscountService discountService;

 

              @GetMapping("/getall")

              public ResponseEntity<?> getAirline() {

                             return new ResponseEntity<>(discountService.getAllDiscount(), HttpStatus.OK);

 

              }

 

              @PostMapping("/save")

              public ResponseEntity<?> saveAirline(@Valid @RequestBody Discount discount) {

 

                             return new ResponseEntity<>(discountService.addDiscount(discount), HttpStatus.OK);

 

              }

 

              @DeleteMapping("/delete/{discountId}")

              public ResponseEntity<?> deleteFlight(@PathVariable Integer discountId) {

 

                             return new ResponseEntity<>(discountService.deleteDiscount(discountId), HttpStatus.OK);

 

              }

 

}