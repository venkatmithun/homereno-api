package com.javachinna.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javachinna.dto.ProfileRequest;
import com.javachinna.model.Profile;
import com.javachinna.model.User;
import com.javachinna.repo.ProfileRepository;
import com.javachinna.repo.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Profile saveUserProfile(ProfileRequest profileRequest) {
		Profile profile = new Profile();
		Date now = Calendar.getInstance().getTime();
		profile.setCreatedDate(now);
		profile.setModifiedDate(now);
		profile.setRequireContract(profileRequest.getRequireContract());
		profile.setProfileType(profileRequest.getProfileType());
		profile = profileRepository.save(profile);
		profileRepository.flush();
		
		// update user 
		Optional<User> optionalUser = userRepository.findById(profileRequest.getUserID());
		if (optionalUser != null) {
			User user = optionalUser.get();
			user.setProfile(profile);
			user = userRepository.save(user);
			userRepository.flush();
		}
		
		return profile;
	}
	
}