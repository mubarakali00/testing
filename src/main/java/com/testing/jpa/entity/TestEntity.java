package com.testing.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.emas.jpa.util.EntityRef;

@Entity
@DynamicUpdate( value = true )
@SelectBeforeUpdate( value = true )
@Table( name = EntityRef.TableTest.TABLE_NAME )
public class TestEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name=EntityRef.TableTest.ID, nullable=false )
	private Integer id;
	
	@Column( name=EntityRef.TableTest.NAME, nullable=false )
	private String name;
	
	@Column( name=EntityRef.TableTest.FATHER_NAME, nullable=true )
	private String fatherName;
	
	public TestEntity(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	

}
