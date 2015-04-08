package com.emas.viewmodel;

import java.util.Date;

public class HospitalViewModel {

	private String id;
	private String hospitalName;
	private String registrationNumber;
	private Date registrationDate;
	private String ministryHealthNumber;
	private String address;
	private String telephoneNumber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getMinistryHealthNumber() {
		return ministryHealthNumber;
	}
	public void setMinistryHealthNumber(String ministryHealthNumber) {
		this.ministryHealthNumber = ministryHealthNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
}
