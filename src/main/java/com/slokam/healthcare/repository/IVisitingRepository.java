package com.slokam.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.healthcare.entity.Visiting;
@Repository
public interface IVisitingRepository extends JpaRepository<Visiting, Integer> {
	@Query(" select p.name,v.dateAndTime from Visiting v join v.appointment a join a.patient p where p.id=?1")
	public List<Object[ ]> getVisitingsById(Integer id);

}//IVisitingRepository
