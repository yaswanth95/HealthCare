package com.slokam.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSerachPojo;


public interface IPatientService {
	public void patientRegistration(Patient patient);
	
	public List<Patient> patientSearch(PatientSerachPojo patientSearchPojo);
	//public List<Patient>  patientFullSearch(PatientSerachPojo patientSearchPojo);
	public List<Patient> getAllPatient();
	public Patient getPatientById(Integer id);
}
