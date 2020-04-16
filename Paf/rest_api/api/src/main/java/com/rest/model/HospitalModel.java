package com.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospitalModel {

	private int hospitalId;
	private String hospitalName;
	private String hospitalRegId;
	private String hospitalAddress;
	private String email;
	private String contactNum;
	private String userName;
	private String password;
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String name) {
		this.hospitalName = name;
	}
	public String getHospitalRegId() {
		return hospitalRegId;
	}
	public void setHospitalRegId(String regId) {
		this.hospitalRegId = regId;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String address) {
		this.hospitalAddress = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}