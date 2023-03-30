package com.flight.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.flight.user.entity.User;

import com.flight.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody User userEntity) {

		try {
			userService.saveUser(userEntity);
			return new ResponseEntity<>(userService.saveUser(userEntity), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>("SignIn failed", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/{userName}")
	public ResponseEntity<?> getUserDetail(@PathVariable String userName) {

		return new ResponseEntity<>(userService.getUser(userName), HttpStatus.OK);
	}

}
