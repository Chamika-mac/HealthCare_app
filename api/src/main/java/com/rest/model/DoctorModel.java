package com.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DoctorModel {

	private int doctorId;
	private String Name;
	private String UserName;
	private String ContactNum;
	private String Email;
	private String Sex;
	private String Address;
	private String Password;
	
	public int getdoctorId() {
		return doctorId;
	}
	public void setdoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getContactNum() {
		return ContactNum;
	}
	public void setContactNum(String ContactNum) {
		this.ContactNum = ContactNum;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String Sex) {
		this.Sex = Sex;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	
}