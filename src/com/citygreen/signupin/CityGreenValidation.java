package com.citygreen.signupin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.citygreen.crud.UserBean;
import com.citygreen.dbconnection.DBConnection;

public class CityGreenValidation {
	
	public List<UserBean> useridvalidate(String mail, String number) {
		
		List<UserBean> userlist = new ArrayList<>();
		
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			
			String Query = "SELECT mail, contact_number, pswd FROM citygreen_dev.user_tbl where (mail = ? or contact_number = ?);";			
			pstmt = connection.prepareStatement(Query);		
			pstmt.setString(1, mail);
			pstmt.setString(2, number);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserBean user = new UserBean();
				user.SetUser_Email(rs.getString(1));
				user.SetUser_Contactnumber(rs.getString(2));
				userlist.add(user);
			}
			
			
		}catch(SQLException e) {
			System.out.println("Exception in SQL, Please check");
			e.printStackTrace();
		}
		
		return userlist;
		
	}

}
