package com.emas.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.emas.jpa.util.EntityRef;

@Entity
@Table( name = EntityRef.TableHospital.TABLE_NAME )
public class HospitalEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
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
	
	@OneToOne( mappedBy = "hospitalEntity" )
	private AdmissionEntity admissionEntity;
	
}
