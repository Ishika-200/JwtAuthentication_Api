package com.jobPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.ApiResponse;
import com.jobPortal.entity.User;
import com.jobPortal.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createUser = this.userServices.createUser(user);
		return new ResponseEntity<User>(createUser, HttpStatus.CREATED);

	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUser() {
		List<User> user = this.userServices.getUser();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		User id = this.userServices.getUserById(userId);
		return new ResponseEntity<User>(id, HttpStatus.OK);
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userId) {
		User Id = this.userServices.updateUser(user, userId);
		return new ResponseEntity<User>(Id, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
		this.userServices.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("deleted successfully", true), HttpStatus.OK);
	}

}
