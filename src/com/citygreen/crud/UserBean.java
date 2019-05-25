package com.citygreen.crud;

public class UserBean {
	
	String name, email, contact_number, location, gender, password;
	int id;
	
	public void SetUser_Name(String name) {
		this.name = name;
	}
	public void SetUser_Contactnumber(String contact_number) {
		this.contact_number = contact_number;
	}
	public void SetUser_Email(String email) {
		this.email = email;
	}
	public void SetUser_location(String location) {
		this.location = location;
	}
	public void SetUser_Gender(String gender) {
		this.gender = gender;
	}
	public void SetUser_Password(String password) {
		this.password = password;
	}
	public void SetUser_Id(int id) {
		this.id = id;
	}
	
	
	public String GetUser_Name() {
		return this.name;
	}
	public String GetUser_Email() {
		return this.email;
	}
	public String GetUser_Contactnumber() {
		return this.contact_number;
	}
	public String GetUser_Location() {
		return this.location;
	}
	public String GetUser_Gender() {
		return this.gender;
	}
	public String GetUser_Password() {
		return this.password;
	}
	public int GetUser_Id() {
		return this.id;
	}

}
