package dao;

import java.io.InputStream;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import controller.HomePageController;
import model.HomePageAdsDTO;
import model.Images;

public class HomePageDao implements GenericDao {
	

	//DataBase connection 
	DataBaseConnection db = new DataBaseConnection ();
	
	// DTO object 
	HomePageAdsDTO dto = new HomePageAdsDTO  ();
	ArrayList<String> posts = new ArrayList<>();
	//ArrayList<InputStream> image = new ArrayList<>();
	ArrayList<Images> imgList = new ArrayList<Images>();
	
	
	public HomePageDao (){
		findAll();
	}
	

	@Override
	public void findAll() {
		
		String message ;
		String query = "SELECT * FROM ads ORDER BY date DESC" ;
	
		
		
		try {
		    	
			java.sql.Statement stmt = db.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		
		
	    /*  while (rs.next())
			{
				
			    posts.add(rs.getString("data"));
			    image.add(rs.getBinaryStream("image"));
			  
			}*/
		
			      while(rs.next()){
			    	  
			       posts.add(rs.getString("data"));
			       Images img = new Images(rs.getBytes("image"));
			       imgList.add(img);
	
			                 }
			
			       rs.close();
			        stmt.close();
			   
			   // call controller
			   new HomePageController (posts, imgList);
			 //  print (posts);
			 
		    
	     	} catch (Exception e)
		
		    {
	     		
	     		e.printStackTrace();
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
