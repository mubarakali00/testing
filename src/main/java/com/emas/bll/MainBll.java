package com.emas.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@Transactional//( propagation = Propagation.REQUIRES_NEW )
	public void dbTesting() {
		
		Hospital();
		Test();
	}
	
//	@Transactional( "emasTransactionManager" )
	private void Hospital() {
		
		HospitalEntity hospital = new HospitalEntity();
		hospital.setAddress( "Testing 12 " );
		hospital.setHospitalName( "Mubarak Ali 12" );
		hospitalRepo.saveAndFlush( hospital );
	}
	
//	@Transactional( "testTransactionManager" )
	private void Test() {
		
		TestEntity test = new TestEntity();
		test.setName("Testing..a.");
		test.setFatherName( "father_test as" );
		testRepo.saveAndFlush( test );
	}
	
}
