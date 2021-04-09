package com.slokam.healthcare.repository;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSerachPojo;
import com.slokam.healthcare.utils.StringUtils;

@Repository
public class PatientCriteriaRepo{
 @Autowired
	private EntityManager em;
 public List<Patient>  patientFullSearch(PatientSerachPojo patientSearchPojo)
  {
	     CriteriaBuilder cb=em.getCriteriaBuilder();
	       CriteriaQuery<Patient> cq= cb.createQuery(Patient.class);
	        Root<Patient> root=cq.from(Patient.class);
	        List<Predicate>predicateList=new ArrayList<>();
	        
	        if(patientSearchPojo!=null) {
	        	if(StringUtils.blankCheck(patientSearchPojo.getName())) {
				/*
				 * Predicate p= cb.like(root.get("name"), patientSearchPojo.getName());
				 * predicateList.add(p);
				 */
	        		predicateList.add( cb.like(root.get("name"), patientSearchPojo.getName()));
	        		
	        	}//name
	        	if(patientSearchPojo.getPhone()!=null) {
	        		predicateList.add( cb.equal(root.get("phone"), patientSearchPojo.getPhone()) );
	        	}//phone
	        	if(patientSearchPojo.getFromdate()!=null) {
	        		predicateList.add( cb.greaterThanOrEqualTo(root.get("regDate"),patientSearchPojo.getFromdate() ));
	        	}//fromDate
	        	if(patientSearchPojo.getTodate()!=null) {
	        		predicateList.add( cb.lessThanOrEqualTo(root.get("regDate"), patientSearchPojo.getTodate()));
	        	}//toDate
	        	if(patientSearchPojo.getStartingAge()!=null) {
	        		predicateList.add(  cb.ge(root.get("age"), patientSearchPojo.getStartingAge()));
	        	}//startingAge
	        	if(patientSearchPojo.getEndingAge()!=null) {
	        		predicateList.add(cb.lessThan(root.get("age"), patientSearchPojo.getEndingAge()));
	        	}//endingAge
	        	//if() {}//gender
	        }
	       
	        cq.where(predicateList.toArray(new Predicate[ predicateList.size()]));
	        TypedQuery<Patient> query=em.createQuery(cq);
	       return  query.getResultList();
	 
	 
	// return null;
 }//patientFullSearch
}
