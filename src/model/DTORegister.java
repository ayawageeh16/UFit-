package model;

public class DTORegister {
    private String firstName , lastName , password, email;
    private int schedule;

  
    public DTORegister (String firstname , String lastname, String password, String email, int schedule)
    {
    	 this.firstName= firstname;
    	 this.lastName=lastname;
    	 this.password= password ;
    	 this.email=email;
    	 this.schedule = schedule;
    }
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public int getSchedule() {
		return schedule;
	}

	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}
