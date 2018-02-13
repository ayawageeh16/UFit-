package services;

import controller.LoginController;
import controller.LoginEmpController;

public class LoginEmpReqService {
	
	//constructor
	public LoginEmpReqService (String email , String password, String job)
	{
		
		new LoginEmpController(email,password, job);
		
	}

}
