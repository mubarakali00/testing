package com.emas.jpa.util;

public class EntityRef {
	
	public static class TableHospital
	{
		public static final String TABLE_NAME = "hospital";
		
		public static final String HOSPITAL_ID = "hospital_id";
		public static final String HOSPITAL_NAME = "hospital_name";
		public static final String REGISTRATION_NUMBER = "registration_number";
		public static final String REGISTRATION_DATE = "registration_date";
		public static final String MINISTRY_HEALTH_NUMBER = "ministry_health_number";
		public static final String ADDRESS = "address";
		public static final String TELEPHONE_NUMBER = "telephone_number";
		
	}
	
	public static class TableClaim
	{
		public static final String TABLE_NAME = "claim";
		
		public static final String CLAIM_ID = "claim_id";
		public static final String CLAIM_NUMBER = "claim_number";
		public static final String GL_NUMBER = "gl_number";
		public static final String ADMISSION_ID = "admission_id";
		public static final String PREPARED_BY = "prepared_by";
		public static final String ISSUED_DATE = "issued_date";
		public static final String HOSPITAL_BILL = "hospital_bill";
		public static final String COVERED_PERIOD = "covered_period";
	}
	
	public static class TableAdmission
	{
		public static final String TABLE_NAME = "admission";
		
		public static final String ADMISSION_ID = "admission_id";
		public static final String ADMISSION_DATE = "admission_date";
		public static final String PATIENT_NAME = "patient_name";
		public static final String DOCTOR_NAME = "doctor_name";
		public static final String NATURE_OF_DISABILITY = "nature_of_disability";
		public static final String NO_OF_DAYS = "no_of_days";
		public static final String ICD_CODE = "icd_code";
		public static final String HOSPITAL_ID = "hospital_id";
		public static final String MEMBER_ID = "member_id";
	}
	
	public static class TableMember
	{
		public static final String TABLE_NAME = "member";
		
		public static final String MEMBER_ID = "member_id";
		public static final String MEMBER_NAME = "member_name";
		public static final String EMPLOYEE_ID = "employee_id";
		public static final String NRIC_NUMBER = "nric_number";
		public static final String PLAN_NUMBER = "plan_number";
		public static final String POLICY_NUMBER = "policy_number";
		public static final String COMPANY_ID = "company_id";	
	}
	
	public static class TableServiceCharges
	{
		public static final String TABLE_NAME = "service_charges";
		
		public static final String SERVICE_CHARGES_ID = "service_charges_id";
		public static final String SERVICE_ID = "service_id";
		public static final String EXPENSES_INCURRED = "expenses_incurred";
		public static final String COMPANY_PAYMENT = "company_payment";
		public static final String EXPENSES_NOT_PAYABLE = "expenses_not_payable";
		public static final String REMARKS = "remarks";
		public static final String ADMISSION_ID = "admission_id";
		public static final String BENEFIT_COVERAGE = "benefit_coverage";	
	}
	
	public static class TableCompany
	{
		public static final String TABLE_NAME = "company";
		
		public static final String COMPANY_ID = "company_id";
		public static final String COMPANY_NAME = "company_name";		
		
	}
	
	public static class TableService
	{
		public static final String TABLE_NAME = "service";
		
		public static final String SERVICE_ID = "service_id";
		public static final String SERVICE_NAME = "service_name";		
		
	}

}
