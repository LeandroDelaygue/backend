package com.octopus.test.demo.service;

import java.util.List;

import com.octopus.test.demo.model.User;

public interface UserService {

	/**
	 * agregar usuario
	 * 
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 * lista usuarios
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * eliminar usuarios
	 * 
	 * @param user
	 * @return
	 */
	void deleteUser(User user);

}
