package com.jobPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobPortal.entity.User_role;

public interface UserRoleRepo extends JpaRepository<User_role, String> {
	User_role findByUserId(String userId);
}
