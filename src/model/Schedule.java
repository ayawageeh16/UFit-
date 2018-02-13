package model;

import java.awt.Image;

public class Schedule {
	private String email , day , exercise , notes;
	Trainee t = new Trainee();
	public Trainee getT() {
		return t;
	}
	public void setT(Trainee t) {
		this.t = t;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	private Image img;

}
