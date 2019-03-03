package com.octopus.test.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.octopus.test.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	@SuppressWarnings("unchecked")
	User save(User user);
	 
}
