package com.slokam.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.repository.IVisitingRepository;
import com.slokam.healthcare.service.IVisitingService;

@Service
public class VisitingServiceImpl implements IVisitingService {
@Autowired
	private IVisitingRepository visitingRepo;
	@Override
	public List<Object[]> getVisitingsById(Integer id) {
		
		return visitingRepo.getVisitingsById(id);
	}
	

}//VisitingServiceImpl
