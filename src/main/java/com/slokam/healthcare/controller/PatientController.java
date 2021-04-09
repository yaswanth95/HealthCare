package com.slokam.healthcare.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSerachPojo;
import com.slokam.healthcare.service.IPatientService;

@RestController
@RequestMapping("patient")//common filed
public class PatientController {
	@Autowired
	private IPatientService  petientService;
	@PostMapping("/register")//patient/register or patient/search....
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient)
	{
		petientService.patientRegistration(patient);
		return  new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
	}//registerPatient
	@PostMapping("/search")
	public ResponseEntity<List<Patient>> patientSearch(@RequestBody PatientSerachPojo patientSearchPojo){
		List<Patient> list=petientService.patientSearch(patientSearchPojo);
		//return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
		return ResponseEntity.ok(list);
	}//patientSearch
	@GetMapping("all")
	public ResponseEntity<List<Patient>> getAll(){
		List<Patient> list=petientService.getAllPatient();
		return ResponseEntity.ok(list);
	}//getAll
	@GetMapping("patientId/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Integer id){
		Patient patient=petientService.getPatientById(id);
		return ResponseEntity.ok(patient);
	}//getPatientById
  //GetAllPatients Using java1.8
	
	@GetMapping("allPatientInfo")
	public ResponseEntity<List<Patient>> getAllPatientInfo(){
		
		List<Patient> patientList=petientService.getAllPatient();
				//.filter( ).collect();
	//	return  ResponseEntity.ok(patientList.stream().filter( (patient)->patient.getId()%2==1).collect(Collectors.toList())) ;
		return  ResponseEntity.ok(patientList.stream().filter( (patient)->patient.getName().equals("Anji")).collect(Collectors.toList())) ;
	

	}//getAll
	
	
	
	
	
}
