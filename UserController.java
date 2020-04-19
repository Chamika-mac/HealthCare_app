package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UserModel;
import DBConnector.Connector;

public class UserController {
	Connector con = Connector.getInstance();

	private UserController() {

	}

	private static final UserController userController = new UserController();

	public static UserController getInstance() {
		return userController;
	}

	public void save(UserModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO user(Name,password,mobileNumber,address,email) VALUES ('" + obj.getName() + "', "
				+ "'" + obj.getPassword() + "', '" + obj.getMobileNumber() + "', '" + obj.getAddress() + "', '" + obj.getEmail()
				 + "')");
	}
}
