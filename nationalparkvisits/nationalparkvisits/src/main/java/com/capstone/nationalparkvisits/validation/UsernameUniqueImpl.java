package com.capstone.nationalparkvisits.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.nationalparkvisits.database.DAO.UsersDAO;
import com.capstone.nationalparkvisits.database.entities.Users;


public class UsernameUniqueImpl implements ConstraintValidator<UsernameUnique, String> {
	public static final Logger LOG = LoggerFactory.getLogger(UsernameUniqueImpl.class);
	
	@Autowired
	private UsersDAO usersDao;
	
	@Override
	public void initialize(UsernameUnique constraintAnnotation) {

	}
	
	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if ( StringUtils.isEmpty(value) ) {
			return true;
		}
		
		Users user = usersDao.findByUsername(value);
		
		return ( user == null );
	}
}
