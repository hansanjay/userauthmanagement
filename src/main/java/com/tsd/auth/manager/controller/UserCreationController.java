package com.tsd.auth.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsd.sdk.request.UserReq;

import com.tsd.auth.manager.service.CustomUserDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/tsd/user")
@CrossOrigin
@Tag(name = "User Registration Controller API", description = "Operations related to user registration")
public class UserCreationController {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@PostMapping(path = "/registration",produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "User Registration Controller API", description = "Operations related to user registration")
    public ResponseEntity<?> getdistributors(@RequestBody UserReq userReq){
		return customUserDetailsService.createUser(userReq);
	}
	
}