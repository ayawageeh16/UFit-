package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import controller.LoginController;
import controller.LoginEmpController;
import model.DTOEmpLogin;
import model.DTOLogin;

public class LoginEmpDao implements GenericDao  {
	 //database connection 
    DataBaseConnection dbc = new DataBaseConnection ();

   // DTOLogin dtobject;
       DTOEmpLogin dtoLogin;
       
   //ControllerLogin
       LoginEmpController lc = new LoginEmpController();
      
    public LoginEmpDao() {};
    //constructor to receive data from employee
    public LoginEmpDao(String email , String password, String job){
   	 dtoLogin = new DTOEmpLogin(email, password, job);
		 findAll();
    }
    
    
    @Override
    public  void findAll(){

   	 
		String searchQuery = "select * from employees where email='" + dtoLogin.getEmail() + "' AND password='" + dtoLogin.getPassword() 
		+ "' AND job='" + dtoLogin.getJob() + "'" ; 
		  
		try {
			
			Statement stmt=dbc.con.createStatement(); 
			ResultSet rs = stmt.executeQuery(searchQuery); 
			boolean empExists = rs.next(); 
			if (!empExists) {
				   lc.response("Email/Password entered is Incorrect or job not matched.", dtoLogin.getJob()); 
			}

			else{
			    lc.response("success", dtoLogin.getJob());	
			}
		}catch (Exception ex) 
			{  
			ex.printStackTrace();
			} 

			
   	 
			}  
		
    @Override
	public List<String> findByID() {
		// TODO Auto-generated method stub
		return null;
	}
    @Override
	public void insert() {
    }
    
    @Override
	public void update(String t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		
	
	}
	

}

