package com.javachinna.service;

import com.javachinna.dto.ProfileRequest;
import com.javachinna.model.Profile;

public interface ProfileService {
	public Profile saveUserProfile(ProfileRequest porfileRequest);

}
