package services;

import controller.RegisterController;

public class RegisterationServiceRequest {

	
	public RegisterationServiceRequest(String firstName, String lastName, String email, String password, int schedule)
	{
		
		new RegisterController(firstName, lastName, email, password, schedule);
	}

}
