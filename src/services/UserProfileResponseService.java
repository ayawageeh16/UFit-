package services;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;

import View.UserProfile;

public class UserProfileResponseService {

	public UserProfileResponseService(String firstname, String lastname, ResultSet rs, String notes, InputStream trophic) {

		UserProfile userProfile = new UserProfile();
		userProfile.response(firstname, lastname, rs, notes, trophic);
		
	}

	
}
