package com.technath.einventory.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_customer")
public class CustomerDO {
	@Id
	@Column(name = "custid")
	private int custId;
	
	@Column(name = "fname")
	private String fName ;

	@Column(name = "lname")
	private String lName ;

	@Column(name = "mname")
	private String mName ;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "houseno")
	private String houseNo;

	@Column(name = "apt")
	private String apt;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "phone")
	private String phone;
	
	
	@Column(name = "mphone")
	private String mphone;
	
	
	@Column(name = "email")
	private String email;


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getHouseNo() {
		return houseNo;
	}


	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}


	public String getApt() {
		return apt;
	}


	public void setApt(String apt) {
		this.apt = apt;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMphone() {
		return mphone;
	}


	public void setMphone(String mphone) {
		this.mphone = mphone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
}

