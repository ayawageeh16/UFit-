package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import dao.LoginEmpDao;
import services.LoginEmpResService;

public class LoginEmpController {
	
	private String email, password;
	static int active = 0;
	
	public LoginEmpController() {};
	public LoginEmpController(String email, String password, String job) {
		this.email = email;
		this.password = password;
		
		checkValidation(email, password, job);
	}

	private void checkValidation(String email, String password, String job) {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		if(b == true) {
			if(password != null) {
				
				LoginEmpDao le = new LoginEmpDao(email, password, job);
			}
		}else {
			
			LoginEmpResService lv = new LoginEmpResService("please Enter valid email and password", job);
		}
		
	}
	
	public void response(String message, String job) {
		new LoginEmpResService(message, job);
	}
	
	
}

