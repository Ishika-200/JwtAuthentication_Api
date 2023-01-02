package com.jobPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobPortal.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, String> {

}
