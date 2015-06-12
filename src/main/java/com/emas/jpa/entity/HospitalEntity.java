package com.emas.jpa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emas.jpa.util.EntityRef;

@Entity
@Table( name = EntityRef.TableHospital.TABLE_NAME )
public class HospitalEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = EntityRef.TableHospital.HOSPITAL_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableHospital.HOSPITAL_NAME, nullable = true, length = 255 )
	private String hospitalName;
	
	@Column( name = EntityRef.TableHospital.REGISTRATION_NUMBER, nullable = true, length = 255 )
	private String registrationNumber;
	
	@Column( name = EntityRef.TableHospital.REGISTRATION_DATE, nullable = true )
	private Date registrationDate;
	
	@Column( name = EntityRef.TableHospital.MINISTRY_HEALTH_NUMBER, nullable = true, length = 255 )
	private String ministryHealthNumber;
	
	@Column( name = EntityRef.TableHospital.ADDRESS, nullable = true, length = 2000 )
	private String address;
	
	@Column( name = EntityRef.TableHospital.TELEPHONE_NUMBER, nullable = true, length = 255 )
	private String telephoneNumber;

	public HospitalEntity(){}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
//	@OneToOne( mappedBy = "hospitalEntity" )
//	private AdmissionEntity admissionEntity;
	
	
	
}
