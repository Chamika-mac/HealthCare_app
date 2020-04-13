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
	
	public void update(AppointmentModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE appointment SET Name = '" + obj.getName() + "', date = '" + obj.getDate() + "', time = '"
				+ obj.getTime() + "'," + "doctor_name = '" + obj.getDoctor_name() + "', email='" + obj.getEmail()
				+ "', contactNum='" + obj.getContactNum() + "' " + "WHERE appointmentId='" + obj.getAppointementId()
				+ "'");
	}
	

	public void delete(AppointmentModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM appointment WHERE appointmentId='" + obj.getAppointementId() + "'");
	}

}
