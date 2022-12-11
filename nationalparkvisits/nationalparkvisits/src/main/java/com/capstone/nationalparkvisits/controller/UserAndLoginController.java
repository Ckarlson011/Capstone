package com.capstone.nationalparkvisits.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.capstone.nationalparkvisits.database.entities.UserRoles;
import com.capstone.nationalparkvisits.database.entities.Users;
import com.capstone.nationalparkvisits.form.SignupForm;
import com.capstone.nationalparkvisits.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserAndLoginController {
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

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		log.debug("signup() method called");
		ModelAndView response = new ModelAndView();
		response.setViewName("signup");
		return response;
	}

	@RequestMapping(value = { "/signup/createuser" }, method = RequestMethod.POST)
	public ModelAndView signupCreateUser(@Valid SignupForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("signup");
		log.debug("this method submits new user form to database");
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
		}
		if (!bindingResult.hasErrors()) {
			Users user = new Users();
			String encodedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(encodedPassword);
			user.setFirstname(form.getFirstname());
			user.setLastname(form.getLastname());
			user.setUsername(form.getUsername());
			user.setEmail(form.getEmail());
			if (!(form.getDescription() == null)) {
				user.setDescription(form.getDescription());
			} else {
				user.setDescription("");
			}
			usersDAO.save(user);
			UserRoles ur = new UserRoles();
			ur.setRoleName("USER");
			ur.setUserId(user.getId());
			userRolesDAO.save(ur);

			authService.changeLoggedInUsername(user.getUsername(), form.getPassword());
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}

		return response;
	}

	@RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
	public ModelAndView signinPage() {
		log.debug("sighin page method called");
		ModelAndView response = new ModelAndView();
		response.setViewName("signin");
		return response;
	}
}
