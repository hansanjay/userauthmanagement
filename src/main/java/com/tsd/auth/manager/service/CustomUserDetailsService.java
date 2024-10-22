package com.tsd.auth.manager.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tsd.sdk.request.UserReq;
import org.tsd.sdk.response.JsonSuccessResponse;

import com.tsd.auth.manager.entity.User;
import com.tsd.auth.manager.repo.UserRepository;

import jakarta.transaction.Transactional;
import lombok.SneakyThrows;

@Service
public class CustomUserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<?> loadUserByUsername(UserReq userReq) {
		if (null != userReq.getMobile()) {
			return ResponseEntity
					.ok(JsonSuccessResponse.ok("Success", 200, userRepository.findByMobile(userReq.getMobile())));
		} else if (null != userReq.getEmail()) {
			return ResponseEntity
					.ok(JsonSuccessResponse.ok("Success", 200, userRepository.findByEmail(userReq.getEmail())));
		} else {
			return ResponseEntity.ok(JsonSuccessResponse.fail("Authentication Failure", 401, null));
		}
	}

	@SneakyThrows
	@Transactional
	public ResponseEntity<?> createUser(UserReq userReq) {

		if (userRepository.findByMobile(userReq.getMobile()) != null) {
			return ResponseEntity.ok(JsonSuccessResponse.fail(
					"Customer already exists with mobile no :" + userReq.getMobile(), HttpStatus.FOUND.value(), null));
		} else if (userRepository.findByEmail(userReq.getEmail()) != null) {
			return ResponseEntity.ok(JsonSuccessResponse
					.fail("Customer already exists with email :" + userReq.getEmail(), HttpStatus.FOUND.value(), null));
		} else {
			Long userId = generateUserId(userReq.getRole());
			User user = User.builder()
					.id(userId)
					.username(userReq.getUsername())
					.password(userReq.getPassword())
					.email(userReq.getEmail())
					.otp(userReq.getOtp())
					.role(userReq.getRole())
					.mobile(userReq.getMobile())
					.build();
			return ResponseEntity.ok(JsonSuccessResponse.ok("Success", 200, userRepository.save(user)));
		}
	}

	public static Long generateUserId(String userType) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddSSS");
		return Long.parseLong(formatter.format(now));
	}

	public static void main(String arr[]) {
		System.out.println(generateUserId("1"));
	}

}