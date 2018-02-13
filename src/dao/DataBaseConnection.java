
package dao;
 
import java.sql.*;

public class DataBaseConnection {
	
	
	String URL = "jdbc:mysql://localhost/test";
	String Username = "root";
	String Password = "123456";
	
	//connection variable 
 public Connection con = null ;
   
    //constructor 
    public DataBaseConnection (){
	 
    	try {
    		
    		 Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(URL,Username,Password);
    	} catch (Exception e)
    	{
    		e.printStackTrace();
    	}
	 
    }
}

