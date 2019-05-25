package com.citygreen.crud;

public class PlantingBean {
	
	String name, contact_number, area_details, date_time, notes, submitted_date;
	int no_of_participants, no_of_plants_req;
	
	public void SetName(String name) {
		this.name = name;
	}
	public void SetContact(String contact_number) {
		this.contact_number = contact_number;
	}
	public void SetArea_details(String area_details) {
		this.area_details = area_details;
	}
	public void SetDate_Time(String date_time) {
		this.date_time = date_time;
	}
	public void SetNotes(String notes) {
		this.notes = notes;
	}
	public void SetParticipants(int no_of_participants) {
		this.no_of_participants = no_of_participants;
	}
	public void SetPlants(int no_of_plants_req) {
		this.no_of_plants_req = no_of_plants_req;
	}
	public void SetPSubmitted_Date(String submitted_date) {
		this.submitted_date = submitted_date;
	}
	
	
	
	
	public String GetName() {
		return this.name;
	}
	public String GetContact() {
		return this.contact_number;
	}
	public String GetArea_details() {
		return this.area_details;
	}
	public String GetDate_Time() {
		return this.date_time;
	}
	public String GetNotes() {
		return this.notes;
	}
	public int GetParticipants() {
		return this.no_of_participants;
	}
	public int GetPlants() {
		return this.no_of_plants_req;
	}
	public String GetSubmitted_Date() {
		return this.submitted_date;
	}
	
}
