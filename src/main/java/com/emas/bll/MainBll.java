package com.emas.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	
	public void dbTesting() {
		
		Hospital();
		Test();
	}
	
	@Transactional( propagation = Propagation.REQUIRED, value = "emasTransactionManager" )
	private void Hospital() {
		
		HospitalEntity hospital = new HospitalEntity();
		hospital.setAddress( "Testing" );
		hospital.setHospitalName( "Mubarak Ali" );
		hospitalRepo.saveAndFlush( hospital );
	}
	
	@Transactional( propagation = Propagation.REQUIRED, value = "testTransactionManager" )
	private void Test() {
		
		TestEntity test = new TestEntity();
		test.setName("Testing...");
		test.setFatherName( "father _test" );
		testRepo.saveAndFlush( test );
	}
	
}
