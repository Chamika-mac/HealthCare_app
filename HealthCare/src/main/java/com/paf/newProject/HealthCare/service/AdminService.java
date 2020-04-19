package com.paf.newProject.HealthCare.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminService {

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

	// Create an new Administrator
	public String createAdmin(String firstName, String lastName, String idNumber, String adminRole, String username,
			String password) {

		String output = "";

		// Identity of the user
		String roleCode = "1";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for inserting";
			}

			// create a prepared statement
			String query = " insert into admin (`FIRST_NAME`, `LAST_NAME`, `ID_NUMBER`, `ADMIN_ROLE`, `ADMIN_USERNAME`, `ADMIN_PASSWORD`, `ROLE_CODE`)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(query);

			// binding values
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, idNumber);
			pst.setString(4, adminRole);
			pst.setString(5, username);
			pst.setString(6, password);
			pst.setString(7, roleCode);

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

	// Find Admin by ID
	public String getAdminById(String idNumber) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database";
			}

			// create a prepared statement
			String query = "SELECT * FROM admin WHERE ID_NUMBER =" + " '" + idNumber + "' ";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery(query);

			while (rst.next()) {

				String AdminName = rst.getString("FIRST_NAME");
				String AdminRole = rst.getString("ADMIN_ROLE");
				String AdminUsername = rst.getString("ADMIN_USERNAME");

				output = "Admin Name : " + AdminName + " & " + "Admin Role : " + AdminRole + " & " + "Admin Username : "
						+ AdminUsername;

			}

			// execute the statement
			con.close();
		}

		catch (Exception e) {
			output = "Error while Finding Admin.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Get all Administrator details
	public String getAllAdmins() {

		String output = "";
		String total = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for inserting";
			}

			// create a prepared statement
			String query = "SELECT * FROM admin";
			String count = "SELECT COUNT(RECORD_ID) AS TOTAL FROM admin";

			Statement pst = con.createStatement();
			ResultSet rst = pst.executeQuery(query);
			ResultSet rstCount = pst.executeQuery(count);

			while (rst.next()) {

				String AdminID = Integer.toString(rst.getInt("RECORD_ID"));
				String FirstName = rst.getString("FIRST_NAME");

				output += "Admin ID : " + AdminID + " & First Name : " + FirstName;

			}

			String numberOfAdmin = Integer.toString(rstCount.getInt("TOTAL"));
			total = numberOfAdmin;

			// execute the statement
			con.close();

		}

		catch (Exception e) {
			output = "Error while Finding dataset.";
			System.err.println(e.getMessage());
		}
		return output + "  " + total;

	}

	// Find Administrator by name
	public String getAdminByName(String firstName) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for finding";
			}

			// Create a prepared statement
			String query = "SELECT * FROM admin WHERE FIRST_NAME=" + " '" + firstName + "' ";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery(query);

			while (rst.next()) {
				String AdminID = Integer.toString(rst.getInt("RECORD_ID"));
				String RoldeCode = Integer.toString(rst.getInt("ROLE_CODE"));
				String FirstName = rst.getString("FIRST_NAME");
				String LastName = rst.getString("LAST_NAME");
				String IdNumber = rst.getString("ID_NUMBER");
				String AdminROle = rst.getString("ADMIN_ROLE");
				String AdminUsername = rst.getString("ADMIN_USERNAME");

				// Assign results to output
				output += " " + AdminID;
				output += " " + RoldeCode;
				output += " " + FirstName;
				output += " " + LastName;
				output += " " + IdNumber;
				output += " " + AdminROle;
				output += " " + AdminUsername;

			}

			// Connection Close
			con.close();

		}

		catch (Exception e) {
			output = "Error while Finding the Admin.";
			System.err.println(e.getMessage());
		}

		// Print
		return output;
	}

	// Get total number of Administrator
	public String getAdminCount() {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for Counting";
			}

			// create a prepared statement
			String count = "SELECT COUNT(*) AS total FROM admin";

			Statement pst = con.createStatement();
			ResultSet rstCount = pst.executeQuery(count);

			while (rstCount.next()) {

				String numberOfAdmin = Integer.toString(rstCount.getInt("total"));
				output = numberOfAdmin;

			}

			// Connection Close
			con.close();

		}

		catch (Exception e) {
			output = "Error while Finding the Admin.";
			System.err.println(e.getMessage());
		}
		return output;

	}

	// Update Administrator details
	public String updateAdmin(String firstName, String lastName, String idNumber, String adminRole, String username,
			String password) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for Updating.";
			}

			// create a prepared statement
			String updateQuery = "UPDATE admin"
					+ "SET FIRST_NAME=?, LAST_NAME=?, ID_NUMBER=? ADMIN_ROLE=?, ADMIN_USERNAME=?, ADMIN_PASSWORD=?"
					+ "WHERE ID_NUMBER=?";

			PreparedStatement pst = con.prepareStatement(updateQuery);

			// Binding Values
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, idNumber);
			pst.setString(4, adminRole);
			pst.setString(5, username);
			pst.setString(6, password);
			pst.setString(7, idNumber);

			// execute the statement
			pst.executeUpdate();

			System.out.println(firstName + "  " + lastName + "   " + password);
			System.out.println(updateQuery);

			pst.close();

			// Connection Close
			con.close();

			output = "Updated Successfully";

		} catch (Exception e) {

			output = "Error while updating the Admin.";
			System.err.println(e.getMessage());
		}
		return output;

	}

	// Delete Administrator using id number
	public String deleteAdmin(String idNumber) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the database for deleting.";

			}
			// create a prepared statement
			String deleteQuery = "DELETE FROM admin WHERE ID_NUMBER=" + " '" + idNumber + "' ";

			PreparedStatement pst = con.prepareStatement(deleteQuery);

			// execute the statement
			pst.execute();
			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {

			output = "Error while deleting the Admin.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
