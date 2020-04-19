package com.paf.newProject.HealthCare.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorService {

	// Connect the Database
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

	// Create New Doctor
	public String createDoctor(String firstName, String lastName, String idNumber, String registrationID,
			String totalAppointment, String username, String password) {

		String output = "";

		// Identify the user category by role code
		String roleCode = "3";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the Database for inserting";
			}

			// create a prepared statement
			String query = " insert into doctor (`ROLE_CODE`, `FIRST_NAME`, `LAST_NAME`, `ID_NUMBER`, `REGISTRATION_ID`, `NUMBER_OF_APPOINTMENTS`, `DOCTOR_USERNAME`, `DOCTOR_PASSWORD`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(query);

			// binding values
			pst.setString(1, roleCode);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, idNumber);
			pst.setString(5, registrationID);
			pst.setString(6, totalAppointment);
			pst.setString(7, username);
			pst.setString(8, password);

			// execute the statement
			pst.execute();
			con.close();

			output = "Doctor Added Successfully";
		}

		catch (Exception e) {
			output = "Error while inserting the data.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Get Doctor details by identity number
	public String getDoctorById(String idNumber) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database";
			}

			// create a prepared statement
			String query = "SELECT * FROM doctor WHERE ID_NUMBER =" + " '" + idNumber + "' ";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery(query);

			while (rst.next()) {

				String RecordId = Integer.toString(rst.getInt("RECORD_ID"));
				String RoleCode = rst.getString("ROLE_CODE");
				String FirstName = rst.getString("FIRST_NAME");
				String LastName = rst.getString("LAST_NAME");
				String IdNumber = rst.getString("ID_NUMBER");
				String regustrationID = rst.getString("REGISTRATION_ID");
				String TotalAppointments = rst.getString("NUMBER_OF_APPOINTMENTS");
				String Username = rst.getString("DOCTOR_USERNAME");
				String Password = rst.getString("DOCTOR_PASSWORD");

				output = RecordId + " & " + FirstName;

			}

			// execute the statement
			con.close();
		}

		catch (Exception e) {
			output = "Error while Finding dataset.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Delete Doctor by doctor id number
	public String deleteDoctor(String idNumber) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR!! - connecting to the database for Delete.";

			}
			// create a prepared statement
			String deleteQuery = "DELETE FROM doctor WHERE ID_NUMBER=" + " '" + idNumber + "' ";

			PreparedStatement pst = con.prepareStatement(deleteQuery);

			// execute the statement
			pst.execute();
			con.close();

			output = "Successfully Deleted";

		} catch (Exception e) {

			output = "Error while deleting the Doctor.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Get Total Number of Doctors
	public String getDoctorCount() {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the doctor database for Counting";
			}

			// create a prepared statement
			String count = "SELECT COUNT(*) AS total FROM doctor";

			Statement pst = con.createStatement();
			ResultSet rstCount = pst.executeQuery(count);

			while (rstCount.next()) {

				String numDoctors = Integer.toString(rstCount.getInt("total"));
				output = numDoctors;

			}

			// Connection Close
			con.close();

		}

		catch (Exception e) {
			output = "Error while Counting the Doctors";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
