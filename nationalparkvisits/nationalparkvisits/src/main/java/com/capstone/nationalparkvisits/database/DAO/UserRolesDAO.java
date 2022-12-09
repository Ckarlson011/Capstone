package com.capstone.nationalparkvisits.database.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.nationalparkvisits.database.entities.UserRoles;

@Repository
public interface UserRolesDAO extends JpaRepository<UserRoles, Long>{
	public UserRoles findById(Integer id);
	public List<UserRoles> findByUserId(Integer userId);
	public List<UserRoles> findByRoleName(String roles);
}
