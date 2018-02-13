package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import View.RegisterationPage;
import dao.RegisterDaoImp;
import services.RegisterationServiceResponse;

public class RegisterController {

	public RegisterController() {}
	
	public RegisterController(String firstName,String LastName,String Email, String password, int schedule) {
		
		
		boolean first = checkValidationOfRegisterationFirstName(firstName);
		boolean last = checkValidationOfRegisterationLastName( LastName);
		boolean email = checkValidationOfRegisterationEmail( Email);
		boolean pass = checkValidationOfRegisterationPassword( password);
		
		if(first == true && last == true && email == true && pass == true) {
			RegisterDaoImp registerDaoImp = new RegisterDaoImp(firstName, LastName, password, Email, schedule);
		}else {
			RegisterationServiceResponse rs = new RegisterationServiceResponse("please Enter valid data", Email);
		}
		
	}
	

	private boolean checkValidationOfRegisterationFirstName(String firstName) {
		Pattern pattern = Pattern.compile("[a-zA-z]+([ '-][a-zA-Z]+)*");
		Matcher matcher = pattern.matcher(firstName);
		boolean b = matcher.matches();
		if(b == true) {
			if(firstName != null ) {
				
				return true;
			}
		}
			
		return false;		
	}
	
	
	private boolean checkValidationOfRegisterationLastName(String LastName) {
		Pattern pattern = Pattern.compile("[a-zA-z]+([ '-][a-zA-Z]+)*");
		Matcher matcher = pattern.matcher(LastName);
		boolean b = matcher.matches();
		if(b == true) {
			if(LastName != null ) {
				
				return true;
			}
		}
		
		return false;
	}
	private boolean checkValidationOfRegisterationEmail(String Email) {
		Pattern pattern = Pattern.compile("^.+@.+\\..+$");
		Matcher matcher = pattern.matcher(Email);
		boolean b = matcher.matches();
		if(b == true) {
			if(Email != null ) {
				
				return true;
			}
		}
		
		return false;
	}
	
	private boolean checkValidationOfRegisterationPassword(String password) {
			if(password.length() > 4 ) {
				
				return true;
			}
		
		return false;
	}
	
	public void resopnse(String email, String message) {
		RegisterationServiceResponse rs = new RegisterationServiceResponse(message, email);
	}
	
	
     
	
}


