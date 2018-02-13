package controller;


import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

import model.HomePageAdsDTO;
import model.Images;
import dao.HomePageDao;
import services.HomePageResponseService;

public class HomePageController {
	
	//call Dao
	public HomePageController ()
	{
		new HomePageDao ();
		
	}
	
	//call response service 
     public HomePageController (ArrayList<String> posts, ArrayList<Images>image) throws SQLException
	{
		  
    		new HomePageResponseService (posts, image);
    }
	  
	   
		
		
}
