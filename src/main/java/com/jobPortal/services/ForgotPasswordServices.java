package com.jobPortal.services;

import com.jobPortal.entity.User;

public interface ForgotPasswordServices {

	String forgot(User user);

	User forgotPassword(String token, String password);

}
