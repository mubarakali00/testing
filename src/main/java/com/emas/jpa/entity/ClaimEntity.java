package com.emas.jpa.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.emas.jpa.util.EntityRef;

@Entity
@Table( name = EntityRef.TableClaim.TABLE_NAME )
public class ClaimEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	@Column( name = EntityRef.TableClaim.CLAIM_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableClaim.CLAIM_NUMBER, nullable = true, length = 255 )
	private String claimNumber;
	
	@Column( name = EntityRef.TableClaim.GL_NUMBER, nullable = true, length = 255 )
	private String glNo;
	
	@Column( name = EntityRef.TableClaim.PREPARED_BY, nullable = true, length = 255 )
	private String preparedBy;
	
	@Column( name = EntityRef.TableClaim.ISSUED_DATE, nullable = true )
	private Date issuedDate;
	
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn( name = EntityRef.TableClaim.ADMISSION_ID )
	private AdmissionEntity admissionEntity;
	
	@Column( name = EntityRef.TableClaim.HOSPITAL_BILL, nullable = true, length = 255 )
	private String hospitalBill;
	
	@Column( name = EntityRef.TableClaim.COVERED_PERIOD, nullable = true, length = 255 )
	private String coveredPeriod;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getGlNo() {
		return glNo;
	}

	public void setGlNo(String glNo) {
		this.glNo = glNo;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getHospitalBill() {
		return hospitalBill;
	}

	public void setHospitalBill(String hospitalBill) {
		this.hospitalBill = hospitalBill;
	}

	public String getCoveredPeriod() {
		return coveredPeriod;
	}

	public void setCoveredPeriod(String coveredPeriod) {
		this.coveredPeriod = coveredPeriod;
	}
		
	
}
