package com.emas.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class ClaimViewModel {

	private String id;
	private String admissionId;
	private String memberName;
	private List<PersonalInfoViewModel> personalInfoList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(String admissionId) {
		this.admissionId = admissionId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public List<PersonalInfoViewModel> getPersonalInfoList() {
		return personalInfoList;
	}
	public void setPersonalInfoList(List<PersonalInfoViewModel> personalInfoList) {
		this.personalInfoList = personalInfoList;
	}
	
	
}
