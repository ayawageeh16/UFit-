package services;

import controller.UserProfileController;

public class UserProfileRequestService {

	public UserProfileRequestService(String email) {
		new UserProfileController(email);
	}
}
