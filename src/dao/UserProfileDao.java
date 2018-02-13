package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import dao.DataBaseConnection;
import model.Trainee;
import controller.UserProfileController;

public class UserProfileDao implements GenericDao{

	//database connection 
	DataBaseConnection dbc;
	Trainee trainee = new Trainee();
	UserProfileController userProfileController = new UserProfileController();
	public UserProfileDao(String email) {
		dbc= new DataBaseConnection ();
		trainee.setEmail(email);
		findAll();
	}
	
	public void findAll() {
		
		String searchQuery = "select * from trainee where email='"+trainee.getEmail()+"'" ;
		String searchQueryForNutrionist;
		
		try {
			
			Statement stmt=dbc.con.createStatement(); 
			ResultSet rs = stmt.executeQuery(searchQuery);
			
			while(rs.next()) {
				trainee.setFirstName(rs.getString("firstname"));
				trainee.setLastName(rs.getString("lastname"));
				trainee.setSchedule(rs.getInt("schedule"));
				
				if(trainee.getSchedule() == 1) {
		        	
		        	searchQuery = "select * from schedule2days" ; 
		        	searchQueryForNutrionist = "select * from nutritionist where schedule=1";
		        	
		        }else if(trainee.getSchedule() == 2) {
		        	
		        	searchQuery = "select * from schedule3days" ;
		        	searchQueryForNutrionist = "SELECT * FROM nutritionist where schedule = 2";

		        	
		        }else {
		        	
		        	searchQuery = "select * from scheduleeverydays" ;
		        	searchQueryForNutrionist = "SELECT * FROM nutritionist where schedule = 3";
		        }
				rs = stmt.executeQuery(searchQuery);
				Statement stmt2=dbc.con.createStatement(); 
		        ResultSet rs2 = stmt2.executeQuery(searchQueryForNutrionist);
		        try {
		        	while(rs2.next()) {
		        		userProfileController.requestFromDao(trainee.getFirstName(), trainee.getLastName(), rs, rs2.getString("nutritionist notes"), rs2.getBinaryStream("trophic system"));
		        	}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		}catch(Exception e) {
		}
	}

	@Override
	public List<String> findByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
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
