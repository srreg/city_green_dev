package com.citygreen.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.citygreen.dbconnection.DBConnection;

public class CityGreenCRUDOperations {

	public void userSignup(UserBean user) {

		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;

		try {
			String Query = "INSERT INTO `citygreen_dev`.`user_tbl` (`name`, `mail`, `contact_number`, `location`, `gender`, `pswd`) VALUES (?, ?, ?, ?, ?, ?);";
			pstmt = connection.prepareStatement(Query);
			pstmt.setString(1, user.GetUser_Name());
			pstmt.setString(2, user.GetUser_Email());
			pstmt.setString(3, user.GetUser_Contactnumber());
			pstmt.setString(4, user.GetUser_Location());
			pstmt.setString(5, user.GetUser_Gender());
			pstmt.setString(6, user.GetUser_Password());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Connection failed, Please try again");
			e.printStackTrace();
		}
	}

	public List<UserBean> userLogin(String mail, String number, String pswd) {

		List<UserBean> userlist = new ArrayList<>();
		Connection connection = DBConnection.getDBConnection();
		ResultSet rs;
		PreparedStatement pstmt;

		try {

			String Query = "SELECT name, mail, contact_number, pswd FROM citygreen_dev.user_tbl where (mail = ? or contact_number = ?) and pswd = ?;";
			pstmt = connection.prepareStatement(Query);
			pstmt.setString(1, mail);
			pstmt.setString(2, number);
			pstmt.setString(3, pswd);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.SetUser_Name(rs.getString(1));
				user.SetUser_Email(rs.getString(2));
				user.SetUser_Contactnumber(rs.getString(3));
				user.SetUser_Password(rs.getString(4));
				userlist.add(user);
			}
			pstmt.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connectiion lost, Please try again");
		}

		return userlist;

	}

	public void postPlantingDetails(PlantingBean plant) {

		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;

		String Query = "INSERT INTO `citygreen_dev`.`planting_slot_tbl` (`volunteer_name`, `contact_number`, `planting_area_details`, `no_of_participants`, `no_of_plants_req`, `planting_date`, `notes`) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try {
			pstmt = connection.prepareStatement(Query);
			pstmt.setString(1, plant.GetName());
			pstmt.setString(2, plant.GetContact());
			pstmt.setString(3, plant.GetArea_details());
			pstmt.setInt(4, plant.GetParticipants());
			pstmt.setInt(5, plant.GetPlants());			
			pstmt.setString(6, plant.GetDate_Time());
			pstmt.setString(7, plant.GetNotes());			

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Connection failed, try again.");
			e.printStackTrace();
		}

	}

	public List<PlantingBean> getVolunteerMessage() {

		List<PlantingBean> plantingdetails = new ArrayList<>();
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;
		ResultSet rs;

		try {

			String Query = "SELECT volunteer_name, contact_number, planting_area_details, no_of_participants, no_of_plants_req, planting_date, notes, registered_timestamp "
					+ "FROM citygreen_dev.planting_slot_tbl WHERE planting_date >= CURDATE() and achieved is null order by planting_date;";
			pstmt = connection.prepareStatement(Query);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PlantingBean plant = new PlantingBean();
				plant.SetName(rs.getString(1));
				plant.SetContact(rs.getString(2));
				plant.SetArea_details(rs.getString(3));
				plant.SetParticipants(rs.getInt(4));
				plant.SetPlants(rs.getInt(5));
				plant.SetDate_Time(rs.getString(6));
				plant.SetNotes(rs.getString(7));
				plant.SetPSubmitted_Date(rs.getString(8));
				
				plantingdetails.add(plant);
				
			}
			pstmt.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Sql exception Occured");
		}

		return plantingdetails;

	}
	
	public List<PlantingBean> getVolunteerOlderMessage() {

		List<PlantingBean> plantingdetails = new ArrayList<>();
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;
		ResultSet rs;

		try {

			String Query = "SELECT volunteer_name, contact_number, planting_area_details, no_of_participants, no_of_plants_req, planting_date, notes FROM citygreen_dev.planting_slot_tbl"
					+ " WHERE planting_date <= CURDATE() and achieved is null order by planting_date;";
			pstmt = connection.prepareStatement(Query);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PlantingBean plant = new PlantingBean();
				plant.SetName(rs.getString(1));
				plant.SetContact(rs.getString(2));
				plant.SetArea_details(rs.getString(3));
				plant.SetParticipants(rs.getInt(4));
				plant.SetPlants(rs.getInt(5));
				plant.SetDate_Time(rs.getString(6));
				plant.SetNotes(rs.getString(7));
				
				plantingdetails.add(plant);
				
			}
			pstmt.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Sql exception Occured");
		}

		return plantingdetails;

	}
	
	public int GetPlant_slotId(String dt) {

		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		int pid = 0;

		try {

			String Query = "SELECT id FROM citygreen_dev.planting_slot_tbl where registered_timestamp = ?;";
			pstmt = connection.prepareStatement(Query);
			pstmt.setString(1, dt);
			
			System.out.println(dt);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pid = rs.getInt(1);
			}
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Sql exception Occured");
		}

		return pid;

	}
	
	public int setAchieve(int id) {

		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;
		int row = 0;

		try {

			String Query = "update citygreen_dev.planting_slot_tbl set achieved = 'achieved' where id = ? ;";
			pstmt = connection.prepareStatement(Query);
			pstmt.setInt(1, id);
			
			row = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Sql exception Occured");
		}

		return row;

	}
	
	public boolean ForgotVerfication(String mail, String number) {

		Connection connection = DBConnection.getDBConnection();
		ResultSet rs;
		PreparedStatement pstmt;

		try {

			String Query = "SELECT mail, contact_number FROM citygreen_dev.user_tbl where (mail = ? and contact_number = ?);";
			pstmt = connection.prepareStatement(Query);
			pstmt.setString(1, mail);
			pstmt.setString(2, number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//rs.close();
				//pstmt.close();
				//connection.close();
				System.out.println("true");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Connectiion lost, Please try again");
		}
		return false;   /*UPDATE `citygreen_dev`.`user_tbl` SET `location` = '4345' WHERE (`contact_number` = '9840360764');*/
	}
	
	public void pswdUpdate(String pswd, String contact) {

		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;

		try {
			String Query = "UPDATE `citygreen_dev`.`user_tbl` SET `pswd` = ? WHERE (`contact_number` = ?);";
			pstmt = connection.prepareStatement(Query);
			pstmt.setString(1, pswd);
			pstmt.setString(2, contact);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Connection failed, Please try again");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CityGreenCRUDOperations cg = new CityGreenCRUDOperations();
		List<PlantingBean> pla = cg.getVolunteerMessage();
		for(PlantingBean det : pla ) {
			System.out.println(det.GetArea_details()+"\t"+det.GetName());
		}
	}

}
