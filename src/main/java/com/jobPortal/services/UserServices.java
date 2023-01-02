package com.jobPortal.services;

import java.util.List;

import com.jobPortal.entity.User;

public interface UserServices {

	User createUser(User user);

	List<User> getUser();

	User getUserById(String userId);

	User updateUser(User user, String userId);

	void deleteUser(String userId);
}
