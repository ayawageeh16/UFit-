package services;

import View.RegisterationPage;

public class RegisterationServiceResponse {
		
	public RegisterationServiceResponse(String message, String email) 
	{
		
		sendToView(message, email);
	}

	private void sendToView(String message, String email) {
		
		RegisterationPage v = new RegisterationPage(message, email);
	}
}
