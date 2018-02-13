package services;


import java.util.ArrayList;

import View.HomePage;
import model.Images;

public class HomePageResponseService {

	
	public HomePageResponseService (ArrayList<String> posts, ArrayList<Images> image)
	{
		new HomePage(posts, image);
		
	}

}
