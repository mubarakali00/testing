package com.emas.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emas.jpa.entity.HospitalEntity;
import com.emas.jpa.repository.IHospitalRepository;
import com.testing.jpa.entity.TestEntity;
import com.testing.jpa.repository.ITestingRepository;

@Service
public class MainBll {

	@Autowired
	
	private IHospitalRepository hospitalRepo;
	
	@Autowired
	private ITestingRepository testRepo;
	
	@Transactional
	public void dbTesting() {
		
		Hospital();
		Test();
	}
	
	private void Hospital() {
		
		HospitalEntity hospital = new HospitalEntity();
		hospital.setAddress( "Testing 14 " );
		hospital.setHospitalName( "Mubarak Ali 14" );
		hospitalRepo.saveAndFlush( hospital );
	}
	
	private void Test() {
		
		TestEntity test = new TestEntity();
		test.setName("Testing... 1234");
		test.setFatherName( "father_test 1234" );
		testRepo.saveAndFlush( test );
	}
	
}
