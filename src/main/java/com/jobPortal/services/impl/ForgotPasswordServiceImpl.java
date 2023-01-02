package com.jobPortal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobPortal.entity.User;
import com.jobPortal.exception.ResourceNotFoundException;
import com.jobPortal.repo.UserRepo;
import com.jobPortal.services.EmailServices;
import com.jobPortal.services.ForgotPasswordServices;

import net.bytebuddy.utility.RandomString;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordServices {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailServices emailServices;

	@Override
	public String forgot(User user) {
		User user1 = this.userRepo.findByEmail(user.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("User", "email : ", user.getEmail()));
		String token = RandomString.make(30);
		user1.setToken(token);
		userRepo.save(user1);
		String t = "http://localhost:8080/confirm-reset?token=" + token;
		boolean sendEmail = emailServices.sendEmail("To complete the password reset process, please click here: ", t,
				user1.getEmail());
		return t;
	}

	@Override
	public User forgotPassword(String token, String password) {
		User user = this.userRepo.findByToken(token)
				.orElseThrow(() -> new ResourceNotFoundException("User", "token", token));

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordEncode = passwordEncoder.encode(password);
		user.setPassword(passwordEncode);
		User saved = this.userRepo.save(user);

		return saved;
	}

}
