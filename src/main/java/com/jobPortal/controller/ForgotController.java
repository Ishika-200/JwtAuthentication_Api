package com.jobPortal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.entity.User;
import com.jobPortal.services.ForgotPasswordServices;

@RestController
public class ForgotController {

	@Autowired
	private ForgotPasswordServices forgotPasswordServices;

	Logger logger = LoggerFactory.getLogger(ForgotController.class);

	@PostMapping("/forgotPassword")
	public ResponseEntity<String> forgotpassword(@RequestBody User user) {

		logger.info("FogotPasswordController is executed successfully");

		String forgot = this.forgotPasswordServices.forgot(user);
		return new ResponseEntity<String>(forgot, HttpStatus.OK);

	}

	@PutMapping("/confirm-reset")
	public ResponseEntity<User> reset(@RequestParam String token, @RequestParam String password) {

		logger.info("resetpasswordController is executed successfully");

		User user = this.forgotPasswordServices.forgotPassword(token, password);

		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
}
