package com.capstone.nationalparkvisits.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.nationalparkvisits.database.DAO.EventsDAO;
import com.capstone.nationalparkvisits.database.DAO.NatparkDAO;
import com.capstone.nationalparkvisits.database.DAO.UserRolesDAO;
import com.capstone.nationalparkvisits.database.DAO.UsersDAO;
import com.capstone.nationalparkvisits.database.DAO.VisitsDAO;
import com.capstone.nationalparkvisits.database.entities.Natpark;
import com.capstone.nationalparkvisits.database.entities.UserRoles;
import com.capstone.nationalparkvisits.database.entities.Users;
import com.capstone.nationalparkvisits.form.SignupForm;
import com.capstone.nationalparkvisits.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

	@Autowired
	EventsDAO eventsDAO;

	@Autowired
	NatparkDAO natparkDAO;

	@Autowired
	UserRolesDAO userRolesDAO;

	@Autowired
	UsersDAO usersDAO;

	@Autowired
	VisitsDAO visitsDAO;

	@Autowired
	private AuthenticatedUserService authService;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView slash() {
		log.debug("slash() method called");
		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		return response;
	}
	
}
