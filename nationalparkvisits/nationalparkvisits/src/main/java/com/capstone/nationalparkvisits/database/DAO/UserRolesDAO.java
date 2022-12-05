package com.capstone.nationalparkvisits.database.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.nationalparkvisits.database.entities.Visits;

public interface UserRolesDAO extends JpaRepository<Visits, Long>{

}
