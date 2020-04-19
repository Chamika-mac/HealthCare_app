package com.paf.newProject.HealthCare.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaymentService {

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

	public String createPayment(String transactionId, String paymentMethod, String userId, String totalAmount) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "error while connecting to the database for insert payment!!";
			}

			// create a prepared statement
			String query = "INSERT INTO payment (`TRANSACTION_ID`, `PAYMENT_METHOD`, `USER_ID`, `TOTAL_AMOUNT`)"
					+ " values (?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(query);

			// binding values
			pst.setString(1, transactionId);
			pst.setString(2, paymentMethod);
			pst.setString(3, userId);
			pst.setString(4, totalAmount);

			// execute the statement
			pst.execute();
			con.close();

			output = "Inserted successfully";
		}

		catch (Exception e) {
			output = "Error while insert payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Find transaction by trasnsactionID
	public String getPaymentById(String transactionId) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the DATABASE!!";
			}

			// create a prepared statement
			String query = "SELECT * FROM payment WHERE TRANSACTION_ID =" + " '" + transactionId + "' ";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rst = pst.executeQuery(query);

			while (rst.next()) {

				String PaymentMethod = rst.getString("PAYMENT_METHOD");
				String UserId = rst.getString("USER_ID");
				String TotalAmount = rst.getString("TOTAL_AMOUNT");

				output = "PaymentMethod : " + PaymentMethod + " & " + "User Id : " + UserId + " & " + "Total Amount : "
						+ TotalAmount;

			}

			// execute the statement
			con.close();
		}

		catch (Exception e) {
			output = "Error while Finding Payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Delete Payment Using transactionId
	public String deletePayment(String transactionId) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Database connecting Error!!!!";

			}

			// create a prepared statement
			String delete = "DELETE FROM payment WHERE TRANSACTION_ID=" + " '" + transactionId + "' ";

			PreparedStatement pst = con.prepareStatement(delete);

			// execute the statement
			pst.execute();
			con.close();

			output = "Payment Deleted Successfully";

		} catch (Exception e) {

			output = "Error while deleting Payment";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Total Number of transactions
	public String getPaymentCount() {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "ERROR while connecting to the payment database for Counting";
			}

			// create a prepared statement
			String count = "SELECT COUNT(*) AS total FROM payment";

			Statement pst = con.createStatement();
			ResultSet rstCount = pst.executeQuery(count);

			while (rstCount.next()) {

				String numOfPayments = Integer.toString(rstCount.getInt("total"));
				output = numOfPayments;

			}

			// Connection Close
			con.close();

		}

		catch (Exception e) {
			output = "Error while Counting the Payments.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
