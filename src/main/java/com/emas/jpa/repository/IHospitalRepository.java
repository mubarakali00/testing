package com.emas.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emas.jpa.entity.HospitalEntity;

@Repository
public interface IHospitalRepository extends JpaRepository<HospitalEntity, Integer> {

	
}
