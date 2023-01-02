package com.jobPortal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.entity.User;
import com.jobPortal.entity.User_role;
import com.jobPortal.exception.ResourceNotFoundException;
import com.jobPortal.repo.UserRepo;
import com.jobPortal.repo.UserRoleRepo;
import com.jobPortal.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Override
	public User createUser(User user) {
		User save = this.userRepo.save(user);
//		User_role user_role = new User_role();
//		user_role.setUserId(user.getId());
//		this.userRoleRepo.save(user_role);

		return save;
	}

	@Override
	public List<User> getUser() {
		List<User> users = this.userRepo.findAll();
		return users;
	}

	@Override
	public User getUserById(String userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return user;
	}

	@Override
	public User updateUser(User user, String userId) {
		User id = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		id.setEmail(user.getEmail());
		id.setPassword(user.getPassword());
		User save = this.userRepo.save(id);
		return save;
	}

	@Override
	public void deleteUser(String userId) {
		User_role user_role = this.userRoleRepo.findByUserId(userId);
		this.userRoleRepo.delete(user_role);
		User id = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepo.delete(id);
	}

}
