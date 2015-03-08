package com.emas.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.emas.jpa.util.EntityRef;

@Entity
@Table( name = EntityRef.TableServiceCharges.TABLE_NAME )
public class ServiceChargesEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	@Column( name = EntityRef.TableServiceCharges.SERVICE_CHARGES_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableServiceCharges.EXPENSES_INCURRED, nullable = true )
	private double expensesIncurred;
	
	@Column( name = EntityRef.TableServiceCharges.COMPANY_PAYMENT, nullable = true )
	private double companyPayment;
	
	@Column( name = EntityRef.TableServiceCharges.EXPENSES_NOT_PAYABLE, nullable = true )
	private double expenseNotPayable;
	
	@Column( name = EntityRef.TableServiceCharges.REMARKS, nullable = true, length = 255 )
	private String remarks;
	
	@Column( name = EntityRef.TableServiceCharges.BENEFIT_COVERAGE, nullable = true, length = 255 )
	private String benefitCoverage;
	
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinColumn( name = EntityRef.TableAdmission.ADMISSION_ID )
	private AdmissionEntity admissionEntity;
	
}
