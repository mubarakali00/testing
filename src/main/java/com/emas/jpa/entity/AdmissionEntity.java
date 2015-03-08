package com.emas.jpa.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.emas.jpa.util.EntityRef;

@Entity
@Table( name = EntityRef.TableAdmission.TABLE_NAME )
public class AdmissionEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	@Column( name = EntityRef.TableAdmission.ADMISSION_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableAdmission.ADMISSION_DATE, nullable = true )
	private Date admissionDate;
	
	@Column( name = EntityRef.TableAdmission.PATIENT_NAME, nullable = true, length = 255 )
	private String patientName;
	
	@Column( name = EntityRef.TableAdmission.DOCTOR_NAME, nullable = true, length = 255 )
	private String doctorName;
	
	@Column( name = EntityRef.TableAdmission.NATURE_OF_DISABILITY, nullable = true, length = 255 )
	private String natureOfDisability;
	
	@Column( name = EntityRef.TableAdmission.NO_OF_DAYS, nullable = true, length = 255 )
	private String noOfDays;
	
	@Column( name = EntityRef.TableAdmission.ICD_CODE, nullable = true, length = 255 )
	private String icdCode;
	
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn( name = EntityRef.TableAdmission.HOSPITAL_ID )
	private HospitalEntity hospitalEntity;
	
	@OneToOne( mappedBy = "admissionEntity" )
	private ClaimEntity claimEntity;
	
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn( name = EntityRef.TableMember.MEMBER_ID )
	private MemberEntity memberEntity;
	
	@OneToMany( mappedBy = "admissionEntity" )
	private List<ServiceChargesEntity> serviceChargesEntityList;
	
}
