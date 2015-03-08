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
@Table( name = EntityRef.TableService.TABLE_NAME )
public class ServiceEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	@Column( name = EntityRef.TableService.SERVICE_ID, nullable = false )
	private Integer id;
	
	@Column( name = EntityRef.TableService.SERVICE_NAME, nullable = true, length = 255 )
	private Date serviceName;
	
}
