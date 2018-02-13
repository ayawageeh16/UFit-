package model;

import java.util.ArrayList ;

public class Employee {
	
	int id ;
	String email , password , job;
	
	
	ArrayList<Exercise> listExercise=new ArrayList<Exercise>();
	public ArrayList<Exercise> getListExercise() {
		return listExercise;
	}
	public void setListExercise(ArrayList<Exercise> listExercise) {
		this.listExercise = listExercise;
	}
	
	
	
	
	ArrayList<Ads> listAds=new ArrayList<Ads>();
	public ArrayList<Ads> getListAds() {
		return listAds;
	}
	public void setListAds(ArrayList<Ads> listAds) {
		this.listAds = listAds;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
