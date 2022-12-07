package com.capstone.nationalparkvisits.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.capstone.nationalparkvisits.database.entities.Users;
import com.capstone.nationalparkvisits.form.SignupForm;

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

	@RequestMapping(value = { "/", "/index"}, method = RequestMethod.GET)
	public ModelAndView slash() {
		log.debug("slash() method called");
		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		return response;
	}
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
	public ModelAndView signup() {
		log.debug("signup() method called");
		ModelAndView response = new ModelAndView();
		response.setViewName("signup");
		return response;
	}
	
	@RequestMapping(value = {"/signup/createuser"}, method = RequestMethod.POST)
	public ModelAndView signupCreateUser(@Valid SignupForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("signup");
		log.debug("this method submits new user form to database");
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
		}
		if ( ! bindingResult.hasErrors()) {
			Users user = new Users();
			String encodedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(encodedPassword);
			//TODO
	}
}
