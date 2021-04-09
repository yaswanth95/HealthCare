package com.slokam.healthcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.service.IVisitingService;

@RestController
@RequestMapping("visiting")
public class VisitingController {
	@Autowired
	private IVisitingService visitingService;
	@GetMapping("/byId/{id}")
public ResponseEntity<List<Object[]>> getVisitingDetailsById(@PathVariable Integer id){
	//List<Object[]> list=visitingService.getVisitingsById(id);

		//return ResponseEntity.ok(list);
	return ResponseEntity.ok(visitingService.getVisitingsById(id));
}//getVisitingDetailsById
}//VisitingController CLass
