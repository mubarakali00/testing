package com.emas.viewmodel;

public class PersonalInfoViewModel {

	private String name;
	private String fatherName;
	private String age;
	private String remarks;
	private boolean newRow;
	
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public boolean isNewRow() {
		return newRow;
	}
	public void setNewRow(boolean newRow) {
		this.newRow = newRow;
	}
	
	public PersonalInfoViewModel() {
		
	}
	
	public PersonalInfoViewModel(String name, String fatherName, String age,
			String remarks, boolean newRow) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.age = age;
		this.remarks = remarks;
		this.newRow = newRow;
	}
	
}
