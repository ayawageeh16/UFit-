package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.LoginDaoImp;
import services.LoginResponsService;

public class LoginController {
	
	private String email, password;
	static int active = 3;
	
	public LoginController() {};
	public LoginController(String email, String password) {
		this.email = email;
		this.password = password;
		
		checkValidation(email, password);
	}

	private void checkValidation(String email, String password) {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");
		Matcher matcher = pattern.matcher(email);
		boolean b = matcher.matches();
		if(b == true) {
			if(password.length()>4) {
				
				LoginDaoImp ld = new LoginDaoImp(email, password);
			}
		}else {
			
			LoginResponsService lv = new LoginResponsService("please Enter valid email and password", email);
		}
		
	}
	
	public void daoResponse(String message, String email) {
		/*if(message != "success") {
			active--;
			if(active == 0) {
				LoginDaoImp ld = new LoginDaoImp();
				ld.daoActive("0", email);
				active = 3;
			}
		}*/
		LoginResponsService lv = new LoginResponsService(message, email);
	}
}
