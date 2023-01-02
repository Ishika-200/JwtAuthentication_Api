package com.jobPortal.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {

	@Id
	private String studentId = UUID.randomUUID().toString().replace("-", "");

	private String studentName;

	private String ssismGroup;

	private String std;

	private String classYear;

	private String gender;

	private String email;

	private String profileImage;

	private String resume;

	private String mobileNo;

	private String qualification;

	private String linkedinUrl;

	private String address;

	private Boolean enabled;

}
