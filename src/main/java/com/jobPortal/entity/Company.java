package com.jobPortal.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Company {
	@Id
	private String cmpId = UUID.randomUUID().toString();

	private String companyName;

	private String ownerName;

	private String email;

	private String companyLocation;

	private String registrationDate;

	private String websiteUrl;

	private String companyLogo;

	private String industryType;

	private String about;

	private boolean enabled = true;

}
