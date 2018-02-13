package services;

import java.awt.Image;
import java.util.Date;

public class AdsRequestService {
	private int id ;
	private String data;
	private Date date;
	private Image img;
	
	
    // constructor
	public AdsRequestService(int id , String data , Date date , Image img) {
		this.id = id ;
		this.data = data;
		this.date = date;
		this.img = img;
		
		
		sendToController(id , data , date , img);
	}

	private void sendToController(int id , String data , Date date , Image img) 
	{
		//AdsController ac  = new AdsController(id , data , date , img);
	}
	


}
