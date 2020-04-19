package com.paf.newProject.HealthCare.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class HospitalService {

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

	public String createHospital(String hospitalName, String hospitalId, String hospitalAddress,
			String hospitalTelephone, String numOfAppointments, String numOfDoctors) {

		String output = "";

		// Identity of the user
		String roleCode = "2";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for inserting";
			}

			// create a prepared statement
			String query = " insert into hospital (`ROLE_CODE`, `HOSPITAL_NAME`, `HOSPITAL_ID`, `HOSPITAL_ADDRESS`, `HOSPITAL_TELEPHONE`, `NUMBER_OF_APPOINTMENTS`, `NUMBER_OF_DOCTORS`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(query);

			// binding values
			pst.setString(1, roleCode);
			pst.setString(2, hospitalName);
			pst.setString(3, hospitalId);
			pst.setString(4, hospitalAddress);
			pst.setString(5, hospitalTelephone);
			pst.setString(6, numOfAppointments);
			pst.setString(7, numOfDoctors);

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

	// Get Hospital by identity number
		public String getHospitalById(String hospitalId) {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "ERROR while connecting to the database";
				}

				// create a prepared statement
				String query = "SELECT * FROM hospital WHERE HOSPITAL_ID =" + " '" + hospitalId + "' ";

				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rst = pst.executeQuery(query);

				while (rst.next()) {

					String HospitalId = rst.getString("HOSPITAL_ID");
					String HospitalName = rst.getString("HOSPITAL_NAME");
					

					output = HospitalId + " & " + HospitalName;

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
		
		// Delete Hospital Using HospitalId
		public String deleteHospital(String hospitalId) {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "Database connecting Error.";

				}
				
				// create a prepared statement
				String delete = "DELETE FROM hospital WHERE HOSPITAL_ID=" + " '" + hospitalId + "' ";

				PreparedStatement pst = con.prepareStatement(delete);

				// execute the statement
				pst.execute();
				con.close();

				output = "Hospital Deleted";

			} catch (Exception e) {

				output = "Error while deleting the hospital.";
				System.err.println(e.getMessage());
			}

			return output;
		}

		// Get Total Number of Hospitals
		public String getHospitalCount() {

			String output = "";

			try {
				Connection con = connect();

				if (con == null) {
					return "ERROR while connecting to the hospital database for Counting";
				}

				// create a prepared statement
				String count = "SELECT COUNT(*) AS total FROM hospital";

				Statement pst = con.createStatement();
				ResultSet rstCount = pst.executeQuery(count);

				while (rstCount.next()) {

					String hospitals = Integer.toString(rstCount.getInt("total"));
					output = hospitals;

				}

				// Connection Close
				con.close();

			}

			catch (Exception e) {
				output = "Error while Counting the Hospitals.";
				System.err.println(e.getMessage());
			}
			return output;
		}

}
