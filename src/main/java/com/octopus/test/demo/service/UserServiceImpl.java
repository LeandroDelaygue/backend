package com.octopus.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.octopus.test.demo.dao.UserRepository;
import com.octopus.test.demo.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		
		return this.userRepository.save(user);
	}
	
}
