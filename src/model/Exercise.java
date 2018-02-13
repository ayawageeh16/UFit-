package model;

import java.util.ArrayList;

public class Exercise {
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name ;
	ArrayList<Employee> listEmployee=new ArrayList<Employee>();
	public ArrayList<Employee> getListEmployee() {
		return listEmployee;
	}
	public void setListEmployee(ArrayList<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

}
