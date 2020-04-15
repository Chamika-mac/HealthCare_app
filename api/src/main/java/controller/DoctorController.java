package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.DoctorModel;

import DBConnector.Connector;

public class DoctorController {

	Connector con = Connector.getInstance();

	private DoctorController() {

	}

	private static final DoctorController ac = new DoctorController();

	public static DoctorController getInstance() {
		return ac;
	}

	public void save(DoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO doctor(Name,UserName,ContactNum,Email,Sex,Address,Password) VALUES ('" + obj.getName()
				+ "', '" + obj.getUserName() + "', '" + obj.getContactNum() + "', '" + obj.getEmail() + "', '"
				+ obj.getSex() + "', " + "'" + obj.getAddress() + "', '" + obj.getPassword() + "')");
	}

	public void update(DoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE doctor SET Name = '" + obj.getName() + "', UserName = '" + obj.getUserName()
				+ "', ContactNum = '" + obj.getContactNum() + "'," + "Email = '" + obj.getEmail() + "', Sex='"
				+ obj.getSex() + "', Address='" + obj.getAddress() + "', Password='" + obj.getPassword() + "' "
				+ "WHERE doctorId='" + obj.getdoctorId() + "'");
	}

	public void delete(DoctorModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM doctor WHERE doctorId='" + obj.getdoctorId() + "'");
	}

	public List<DoctorModel> searchAll() throws Exception {
		List<DoctorModel> list = new ArrayList<DoctorModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM doctor");
		while (rset.next()) {
			DoctorModel obj = new DoctorModel();
			obj.setdoctorId(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setUserName(rset.getString(3));
			obj.setContactNum(rset.getString(4));
			obj.setEmail(rset.getString(5));
			obj.setSex(rset.getString(6));
			obj.setAddress(rset.getString(7));
			obj.setPassword(rset.getString(8));

			list.add(obj);
		}
		return list;
	}

	public DoctorModel search(int doctorId) throws Exception {
		con.getConnection();
		DoctorModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM doctor WHERE doctorId='" + doctorId + "'");
		while (rset.next()) {
			obj = new DoctorModel();
			obj.setdoctorId(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setUserName(rset.getString(3));
			obj.setContactNum(rset.getString(4));
			obj.setEmail(rset.getString(5));
			obj.setSex(rset.getString(6));
			obj.setAddress(rset.getString(7));
			obj.setPassword(rset.getString(8));

		}
		return obj;
	}

}
