package com.PAFAssignment.HealthCare2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminService {

	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare_db", "root", "");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return con;
	}

	public String createAdmin(String firstName, String lastName, String idNumber, String adminRole, String username, String password) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for inserting";
			}
			
			// create a prepared statement
			String query = " insert into admin (`FIRST_NAME`, `LAST_NAME`, `ID_NUMBER`, `ADMIN_ROLE`, `ADMIN_USERNAME`, `ADMIN_PASSWORD`)" + " values (?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(query);

			// binding values
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, idNumber);
			pst.setString(4, adminRole);
			pst.setString(5, username);
			pst.setString(6, password);

			// execute the statement
			pst.execute();
			con.close();

			output = "Inserted successfully";
		}

		catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
