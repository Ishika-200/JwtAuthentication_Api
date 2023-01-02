package com.jobPortal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobPortal.entity.User;
import com.jobPortal.exception.ResourceNotFoundException;
import com.jobPortal.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		loading user from database by email

		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email : ", username));
//		System.out.println(username);

		return user;
	}

}
