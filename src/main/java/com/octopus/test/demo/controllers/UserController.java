package com.octopus.test.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octopus.test.demo.model.User;
import com.octopus.test.demo.service.UserService;
import com.octopus.test.demo.util.RestResponse;

@RestController
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson,User.class);
		
		if (!this.validate(user)) {
			
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos son obligatorios");
		}
		
		this.userService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(),"Operación exitosa");
		
	}
	
	private boolean validate(User user) {
		boolean isvalid=true;
		
		if (user.getFirstName()==null ) {
			isvalid = false;
		}
		return isvalid;
	}

}
