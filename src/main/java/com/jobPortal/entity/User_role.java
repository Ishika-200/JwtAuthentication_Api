package com.jobPortal.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User_role {

	@Id
	private String id = UUID.randomUUID().toString();

	private String userId;

	private String roleId;
}
