package services;

import java.util.List;

import View.LoginView;

public class LoginResponsService {
	
	//constructor 
	public LoginResponsService(String message, String email)
	{
		new LoginView(message, email);
	}
	
	

}
