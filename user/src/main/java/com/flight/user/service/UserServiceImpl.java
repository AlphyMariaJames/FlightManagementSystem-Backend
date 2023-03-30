package com.flight.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.flight.user.entity.User;

import com.flight.user.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

	@Autowired

	private UserRepository userRepository;

	@Override

	public User saveUser(User userEntity) {

		// userRepository.save(userEntity);

		return userRepository.save(userEntity);

	}

	@Override

	public User getUser(String userName) {

		// TODO Auto-generated method stub

		return userRepository.findByUserName(userName).get();

	}

}