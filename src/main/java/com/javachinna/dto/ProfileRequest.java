package com.javachinna.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProfileRequest {

	private Long userID;

	private Boolean requireContract;
	
	private Integer profileType;
	
	public ProfileRequest(Long userID, Boolean requireContract, Integer profileType) {
		this.userID = userID;
		this.requireContract = requireContract;
		this.profileType = profileType;
	}
}