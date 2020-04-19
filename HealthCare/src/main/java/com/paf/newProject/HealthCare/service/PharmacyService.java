package com.paf.newProject.HealthCare.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PharmacyService {

	// Database Connection
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

	// Create a new pharmacy
	public String createPharmacy(String pharmacyId, String pharmacyName, String address, String telephone) {

		String output = "";

		// Identity of the user
		String roleCode = "1";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for inserting";
			}

			// create a prepared statement
			String insertQuery = "INSERT INTO pharmacy (`ROLE_CODE`, `PHARMACY_ID`, `PHARMACY_NAME`, `PHARMACY_ADDRESS`, `PHARMACY_TELEPHONE`)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(insertQuery);

			// binding values
			pst.setString(1, roleCode);
			pst.setString(2, pharmacyId);
			pst.setString(3, pharmacyName);
			pst.setString(4, address);
			pst.setString(5, telephone);

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

	// Find Pharmacy by pharmacyId
	public String getPharmacyById(String pharmacyId) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the DATABASE!!";
			}

			// create a prepared statement
			String query = "SELECT * FROM pharmacy WHERE PHARMACY_ID =" + " '" + pharmacyId + "' ";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery(query);

			while (rst.next()) {

				String PharmacyName = rst.getString("PHARMACY_NAME");
				String PharmacyAddress = rst.getString("PHARMACY_ADDRESS");
				String PharmacyNumber = rst.getString("PHARMACY_TELEPHONE");

				output = "Pharmacy Name : " + PharmacyName + " & " + "Pharmacy Address : " + PharmacyAddress + " & "
						+ "Pharmacy Number : " + PharmacyNumber;

			}

			// execute the statement
			con.close();
		}

		catch (Exception e) {
			output = "Error while Finding Pharmacy.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Find Pharmacy by pharmacy name
	public String getPharmacyByName(String pharmacyName) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the DATABASE!!";
			}

			// create a prepared statement
			String query = "SELECT * FROM pharmacy WHERE PHARMACY_NAME =" + " '" + pharmacyName + "' ";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery(query);

			while (rst.next()) {

				String PharmacyName = rst.getString("PHARMACY_NAME");
				String PharmacyAddress = rst.getString("PHARMACY_ADDRESS");
				String PharmacyNumber = rst.getString("PHARMACY_TELEPHONE");

				output = "Pharmacy Name : " + PharmacyName + " & " + "Pharmacy Address : " + PharmacyAddress + " & "
						+ "Pharmacy Number : " + PharmacyNumber;

			}

			// execute the statement
			con.close();
		}

		catch (Exception e) {
			output = "Error while Finding Pharmacy.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Get total number of Pharmacies
	public String getPharmacyCount() {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for Counting";
			}

			// create a prepared statement
			String countPharmacy = "SELECT COUNT(*) AS total FROM pharmacy";

			Statement pst = con.createStatement();
			ResultSet rstCount = pst.executeQuery(countPharmacy);

			while (rstCount.next()) {

				String numberOfPharmacy = Integer.toString(rstCount.getInt("total"));
				output = numberOfPharmacy;

			}

			// Connection Close
			con.close();

		}

		catch (Exception e) {
			output = "Error while Finding the Pharmacy.";
			System.err.println(e.getMessage());
		}
		return output;

	}

	// Update Pharmacy details
	public String updatePharmacy(String pharmacyId, String pharmacyName, String address, String telephone) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for Updating.";
			}

			// create a prepared statement
			String updateQuery = "UPDATE pharmacy"
					+ "SET PHARMACY_ID=?, PHARMACY_NAME=?, PHARMACY_ADDRESS=? PHARMACY_TELEPHONE=?"
					+ "WHERE PHARMACY_ID=?";

			PreparedStatement pst = con.prepareStatement(updateQuery);

			// Binding Values
			pst.setString(1, pharmacyId);
			pst.setString(2, pharmacyName);
			pst.setString(3, address);
			pst.setString(4, telephone);
			pst.setString(5, pharmacyId);

			// execute the statement
			pst.executeUpdate();

			System.out.println(updateQuery);

			pst.close();

			// Connection Close
			con.close();

			output = "Updated Successfully";

		} catch (Exception e) {

			output = "Error while updating the Pharmacy.";
			System.err.println(e.getMessage());
		}
		return output;

	}

	// Delete Pharmacy using id number
	public String deletePharmacy(String pharmacyId) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for Deleting.";

			}
			// create a prepared statement
			String deleteQuery = "DELETE FROM pharmacy WHERE PHARMACY_ID=" + " '" + pharmacyId + "' ";

			PreparedStatement pst = con.prepareStatement(deleteQuery);

			// execute the statement
			pst.execute();
			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {

			output = "Error while deleting the Pharmacy.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
