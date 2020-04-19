package com.paf.newProject.HealthCare.model;

public class Payment {
	private int payid; /* Payment id */
	private int bid; /* Bill id */
	private float cost; /* Amount */
	private String address;
	private String dname; /* Doctor name */
	private String pname; /* patients name */
	private String image; /* patient image */

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int payid, int bid, float cost, String address) {
		super();
		this.payid = payid;
		this.bid = bid;
		this.cost = cost;
		this.address = address;
	}

	public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}

	public int getbid() {
		return bid;
	}

	public void setPid(int bid) {
		this.bid = bid;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Payment [payid=" + payid + ", bid=" + bid + ", cost=" + cost + ", address=" + address + "]";
	}

}
