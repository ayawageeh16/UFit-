package model;

public class DTOEmpLogin {
	
	public DTOEmpLogin(String email , String password, String job){
		this.email=email;
		this.password = password;
		this.job = job;
	}
	
	
    String email , password, job;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
