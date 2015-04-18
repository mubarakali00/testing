package com.testing.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.jpa.entity.TestEntity;

@Repository
public interface ITestingRepository extends JpaRepository<TestEntity, Integer> {

	
}
