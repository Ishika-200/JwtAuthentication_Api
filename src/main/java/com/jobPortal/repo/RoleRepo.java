package com.jobPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobPortal.entity.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

}
