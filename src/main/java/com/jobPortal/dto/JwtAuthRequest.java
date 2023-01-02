package com.jobPortal.dto;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;

	private String password;

}
