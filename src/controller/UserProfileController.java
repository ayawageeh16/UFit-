package controller;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;

import dao.UserProfileDao;
import services.UserProfileResponseService;

public class UserProfileController {

	public UserProfileController() {};
	
	public UserProfileController(String email) {
		new UserProfileDao(email);
	}
	
	public void requestFromDao(String firstname, String lastname, ResultSet rs, String notes, InputStream trophic) {
		new UserProfileResponseService(firstname, lastname, rs, notes, trophic);
	}
}
