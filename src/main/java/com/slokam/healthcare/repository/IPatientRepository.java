package com.slokam.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
	
	
}
