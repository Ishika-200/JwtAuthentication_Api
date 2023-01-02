package com.jobPortal.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobPortal.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

//	@Query("Select u from User u Where u.email =:email")
	Optional<User> findByEmail(String email);

//	@Query("Select u from User u Where u.token =:token")
	Optional<User> findByToken(String token);

}
