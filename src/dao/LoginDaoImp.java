
package dao;

import java.sql.*;
import java.util.List;

import controller.LoginController;
import model.DTOLogin;
import model.DTORegister;

public class LoginDaoImp implements GenericDao {
	
	     //database connection 
	     DataBaseConnection dbc = new DataBaseConnection ();
	
        // DTOLogin dtobject;
	        DTOLogin dtoLogin;
	        
	    //ControllerLogin
	        LoginController lc = new LoginController();
	       
	     public LoginDaoImp() {};
	     //constructor to receive data from trainee 
	     public LoginDaoImp(String email , String password){
	    	 dtoLogin = new DTOLogin(email, password);
			 findAll();
	     }
	     
	     
	     @Override
	     public  void findAll(){

	    	 
			String searchQuery = "select * from trainee where email='" + dtoLogin.getEmail() + "' AND password='" + dtoLogin.getPassword() + "'" ; 
			  
			try {
				
				Statement stmt=dbc.con.createStatement(); 
				ResultSet rs = stmt.executeQuery(searchQuery); 
				boolean traineeExists = rs.next(); 
				if (!traineeExists) { 
					lc.daoResponse("Email/Password entered is Incorrect or trainee doesnot Exists.", dtoLogin.getEmail());
				}
				else{
				    lc.daoResponse("success", dtoLogin.getEmail());
				}
			}catch (Exception ex) 
				{ 
				lc.daoResponse("Log In failed: An Exception has occurred! " + ex, dtoLogin.getEmail()); 
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
	 	
	 	public void daoActive(String active, String email)
	 	{
	 		String query = "insert into trainee (active) values (?) where email='"+email+"'";
			try {
				
				PreparedStatement pstmt = dbc.con.prepareStatement(query);
				pstmt.setString(1, active);
				pstmt.executeUpdate();

		     }
		     catch (Exception e)
		     {
		    	System.out.println(e.getMessage());
		     }
	 	
		}
	
}
    