package com.capstone.nationalparkvisits.database.DAO;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.nationalparkvisits.database.entities.Visits;

@Repository
public interface VisitsDAO extends JpaRepository<Visits, Long>{
	public Visits findById(Integer id);
	public List<Visits> findByNatparksId(Integer natparksId);
	public List<Visits> findByUsersId(Integer usersId);
	public List<Visits> findByStart(Date start);
	public List<Visits> findByEnd(Date end);
}