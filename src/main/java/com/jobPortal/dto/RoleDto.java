package com.jobPortal.dto;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {

	private String id = UUID.randomUUID().toString();

	private String name;

}
