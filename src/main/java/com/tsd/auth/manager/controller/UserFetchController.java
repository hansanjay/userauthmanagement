package com.tsd.auth.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsd.auth.manager.service.CustomUserDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/tsd/user")
@CrossOrigin
@Tag(name = "Fetch all user data API", description = "Retrieve a list of all User data")
public class UserFetchController {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@GetMapping(path = "/fetch/{mobile}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Fetch all user data", description = "Retrieve a list of all User data")
	public ResponseEntity<?> loadUserByMobile(@PathVariable String mobile){
        //return customUserDetailsService.loadUserByMobileNumber(mobile);
		return null;
    }

}