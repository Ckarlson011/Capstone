package com.capstone.nationalparkvisits.database.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.nationalparkvisits.database.entities.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Long>{
	public Users findById(Integer id);
	public List<Users> findByFirstname(String firstname);
	public List<Users> findByLastname(String lastname);
	public List<Users> findByemail(String email);
	public List<Users> findByUsername(String username);
}