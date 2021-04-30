package com.javachinna.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javachinna.dto.ApiResponse;
import com.javachinna.dto.ProfileRequest;
import com.javachinna.service.ProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	@Autowired
	ProfileService profileService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProfile(@Valid @RequestBody ProfileRequest profileRequest) {
		try {
			profileService.saveUserProfile(profileRequest);
		} catch (Exception e) {
			log.error("Exception Ocurred", e);
			return new ResponseEntity<>(new ApiResponse(false, "Profile could not be saved!"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(new ApiResponse(true, "Profile saved successfully"));
	}
}