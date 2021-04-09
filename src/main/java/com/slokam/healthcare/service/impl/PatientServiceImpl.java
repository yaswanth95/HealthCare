package com.slokam.healthcare.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSerachPojo;
import com.slokam.healthcare.repository.IPatientRepository;
import com.slokam.healthcare.repository.PatientCriteriaRepo;
import com.slokam.healthcare.service.IPatientService;
@Service
public class PatientServiceImpl implements IPatientService{
   @Autowired
private IPatientRepository patientRepo;
   @Autowired
   private PatientCriteriaRepo patientCriteriarepo;
	@Override
	public void patientRegistration(Patient patient) {
		patient.setRegDate(new Date());//
		patientRepo.save(patient);
		
		
	}
	@Override
	public List<Patient> patientSearch(PatientSerachPojo patientSearchPojo) {
		/*
		 * List<Patient> list=patientRepo.patientFullSearch(patientSearchPojo); return
		 * list;*/
		 return patientCriteriarepo.patientFullSearch(patientSearchPojo);
		
	}
@Override
	public List<Patient> getAllPatient() {
		
		return patientRepo.findAll();
	}
@Override
public Patient getPatientById(Integer id) {
	
	 Optional<Patient> optional=patientRepo.findById(id);
	 if(optional.isPresent())
	 {
		 return optional.get();
	 }
	return null;
}
	

}
