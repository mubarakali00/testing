package com.emas.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emas.jpa.util.EntityRef;

@Entity
@Table( name = EntityRef.TableCompany.TABLE_NAME )
public class CompanyEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	@Column( name = EntityRef.TableCompany.COMPANY_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableCompany.COMPANY_NAME, nullable = true, length = 255 )
	private Date companyName;
}
