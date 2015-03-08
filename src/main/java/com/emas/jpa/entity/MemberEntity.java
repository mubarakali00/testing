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
@Table( name = EntityRef.TableMember.TABLE_NAME )
public class MemberEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	@Column( name = EntityRef.TableMember.MEMBER_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableMember.MEMBER_NAME, nullable = true, length = 255 )
	private Date memberName;
	
	@Column( name = EntityRef.TableMember.EMPLOYEE_ID, nullable = true, length = 255 )
	private String employeeId;
	
	@Column( name = EntityRef.TableMember.NRIC_NUMBER, nullable = true, length = 255 )
	private String nricNumber;
	
	@Column( name = EntityRef.TableMember.PLAN_NUMBER, nullable = true, length = 255 )
	private String planNo;
	
	@Column( name = EntityRef.TableMember.POLICY_NUMBER, nullable = true, length = 255 )
	private String policyNo;
	
	@OneToOne( mappedBy = "memberEntity" )
	private AdmissionEntity admissionEntity;
	
}
