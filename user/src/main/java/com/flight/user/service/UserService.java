package com.flight.user.service;

import com.flight.user.entity.User;

public interface UserService {

	public User saveUser(User userEntity);

	public User getUser(String userName);
}
