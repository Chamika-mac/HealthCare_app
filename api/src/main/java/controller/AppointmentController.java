package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.AppointmentModel;

import DBConnector.Connector;

public class AppointmentController {

	Connector con = Connector.getInstance();

	private AppointmentController() {

	}

	private static final AppointmentController ac = new AppointmentController();

	public static AppointmentController getInstance() {
		return ac;
	}

	public void save(AppointmentModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO appointment(Name,date,time,doctor_name,email,contactNum) VALUES ('" + obj.getName() + "', "
				+ "'" + obj.getDate() + "', '" + obj.getTime() + "', '" + obj.getDoctor_name() + "', '" + obj.getEmail()
				+ "', " + "'" + obj.getContactNum() + "')");
	}

}
