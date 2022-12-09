package com.capstone.nationalparkvisits.database.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.nationalparkvisits.database.entities.Natpark;

@Repository
public interface NatparkDAO extends JpaRepository<Natpark, Long>{
	public Natpark findById(Integer id);
	public List<Natpark> findByName(String name);
	public List<Natpark> findByState(String state);
	
	@Query(value = "select name, state, description from natparks", nativeQuery = true)
	public List<Map<String,Object>> findAllParks();
}