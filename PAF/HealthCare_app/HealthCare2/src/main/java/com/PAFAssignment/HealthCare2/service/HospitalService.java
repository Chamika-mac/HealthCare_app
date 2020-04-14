package com.PAFAssignment.HealthCare2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HospitalService {
	
	
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare_db", "root", "ltt76100");

		} catch (Exception e) {
			e.printStackTrace();

		}

		return con;
	}

	public String registerHospital(String hospitalName, String hospitalId, String hospitalAddress, String phoneNo, String doctorDetails, String appointmentDetails, String userName, String password) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Hospital ERROR while connecting to the database for inserting";
			}
			
			// create a prepared statement
			String query = " insert into hospital (`HOSPITAL_NAME`, `HOSPITAL_ID`, `HOSPITAL_ADDRESS`, `PHONE_NO`, `DOCTOR_DETAILS`, `APPOINTMENT_DETAILS`, `HOSPITAL_USERNAME`, `HOSPITAL_PASSWORD`)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(query);

			// binding values
			pst.setString(1, hospitalName);
			pst.setString(2, hospitalId);
			pst.setString(3, hospitalAddress);
			pst.setString(4, phoneNo);
			pst.setString(5, doctorDetails);
			pst.setString(6, appointmentDetails);
			pst.setString(7, userName);
			pst.setString(8, password);

			// execute the statement
			pst.execute();
			con.close();

			output = "Hospital Inserted successfully";
		}

		catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
