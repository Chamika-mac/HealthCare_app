package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.HospitalModel;

import DBConnector.Connector;

public class HospitalController {

	Connector con = Connector.getInstance();

	private HospitalController() {

	}

	private static final HospitalController ac = new HospitalController();

	public static HospitalController getInstance() {
		return ac;
	}

	public void save(HospitalModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO hospital(hospitalName,hospitalRegId,hospitalAddress,email,contactNum,userName,password) VALUES ('" + obj.getHospitalName()
				+ "', '" + obj.getHospitalRegId() + "', '" + obj.getHospitalAddress() + "', '" + obj.getEmail() + "', '"
				+ obj.getContactNum() + "', " + "'" + obj.getUserName() + "', '" + obj.getPassword() + "')");
	}

	public void update(HospitalModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE hospital SET hospitalName = '" + obj.getHospitalName() + "', hospitalRegId = '" + obj.getHospitalRegId() + "', hospitalAddress = '"
				+ obj.getHospitalAddress() + "'," + "email = '" + obj.getEmail() + "', contactNum ='" + obj.getContactNum()
				+ "', userName ='" + obj.getUserName() + "', password ='" + obj.getPassword() + "' " + "WHERE hospitalId='" + obj.getHospitalId()
				+ "'");
	}
	

	public void delete(HospitalModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM hospital WHERE hospitalId='" + obj.getHospitalId() + "'");
	}
	
	public List<HospitalModel> searchAll() throws Exception {
		List<HospitalModel> list = new ArrayList<HospitalModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM hospital");
		while (rset.next()) {
			HospitalModel obj = new HospitalModel();
			obj.setHospitalId(rset.getInt(1));
			obj.setHospitalName(rset.getString(2));
			obj.setHospitalRegId(rset.getString(3));
			obj.setHospitalAddress(rset.getString(4));
			obj.setEmail(rset.getString(5));
			obj.setContactNum(rset.getString(6));
			obj.setUserName(rset.getString(7));
			obj.setPassword(rset.getString(8));

			list.add(obj);
		}
		return list;
	}

	public HospitalModel search(int hospitalId) throws Exception {
		con.getConnection();
		HospitalModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM hospital WHERE hospitalId='" + hospitalId + "'");
		while (rset.next()) {
			obj = new HospitalModel();
			obj.setHospitalId(rset.getInt(1));
			obj.setHospitalName(rset.getString(2));
			obj.setHospitalRegId(rset.getString(3));
			obj.setHospitalAddress(rset.getString(4));
			obj.setEmail(rset.getString(5));
			obj.setContactNum(rset.getString(6));
			obj.setUserName(rset.getString(7));
			obj.setPassword(rset.getString(8));

		}
		return obj;
	}         

}
