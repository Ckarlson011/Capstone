package com.capstone.nationalparkvisits.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.nationalparkvisits.database.DAO.EventsDAO;
import com.capstone.nationalparkvisits.database.DAO.NatparkDAO;
import com.capstone.nationalparkvisits.database.DAO.UserRolesDAO;
import com.capstone.nationalparkvisits.database.DAO.UsersDAO;
import com.capstone.nationalparkvisits.database.DAO.VisitsDAO;
import com.capstone.nationalparkvisits.database.entities.Natpark;
import com.capstone.nationalparkvisits.database.entities.Users;
import com.capstone.nationalparkvisits.database.entities.Visits;
import com.capstone.nationalparkvisits.form.NewVisitForm;
import com.capstone.nationalparkvisits.form.SignupForm;
import com.capstone.nationalparkvisits.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class VisitController {
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

	@RequestMapping(value = { "/createVisit" }, method = RequestMethod.GET)
	public ModelAndView createVisitPage() {
		log.debug("displaying create visit page");
		ModelAndView response = new ModelAndView();

		response.setViewName("createVisit");
		return response;
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = { "/createVisit" }, method = RequestMethod.POST)
	public ModelAndView createVisitPost(@Valid NewVisitForm form, BindingResult bindingResult) throws ParseException {
		log.debug("this method submits the visit form to the database");
		ModelAndView response = new ModelAndView();
		response.setViewName("createVisit");
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
		}
		if (!bindingResult.hasErrors()) {
			log.debug(form.getEnd());
			log.debug(form.getStart());
			Visits visit = new Visits();
			visit.setDescription(form.getDescription());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			visit.setEnd(format.parse(form.getEnd()));
			visit.setNatparksId(form.getPark());
			visit.setStart(format.parse(form.getStart()));
			visit.setUsersId(authService.getCurrentUser().getId());
			visitsDAO.save(visit);
			response.setViewName("index");

		}
		return response;
	}
	
	@RequestMapping(value = { "/myVisits"}, method = RequestMethod.GET)
	public ModelAndView myVisitsPage() {
		log.debug("this method creates the myVisits page");
		ModelAndView response = new ModelAndView();
		List<Visits> visitsResults = visitsDAO.findByUsersId(authService.getCurrentUser().getId());
		List<Map<String, Object>> visits = new ArrayList<Map<String, Object>>();
		for (Visits c: visitsResults) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", c.getId());
			Natpark park = natparkDAO.findById(c.getNatparksId());
			map.put("natpark", park.getName());
			Users user = usersDAO.findById(c.getUsersId());
			map.put("user", user.getUsername());
			map.put("end", c.getEnd());
			map.put("start", c.getStart());
			map.put("description", c.getDescription());
			visits.add(map);
		}
		response.setViewName("parkVisits");
		response.addObject("visits", visits);
		
		return response;
	}
	
	@RequestMapping(value = { "/parkVisits"}, method = RequestMethod.GET)
	public ModelAndView parkVisitsPage(@RequestParam(required = true) Integer id) {
		log.debug("this method creates the parkVisits page");
		ModelAndView response = new ModelAndView();
		List<Visits> visitsResults = visitsDAO.findByNatparksId(id);
		List<Map<String, Object>> visits = new ArrayList<Map<String, Object>>();
		for (Visits c: visitsResults) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", c.getId());
			Natpark park = natparkDAO.findById(c.getNatparksId());
			map.put("natpark", park.getName());
			Users user = usersDAO.findById(c.getUsersId());
			map.put("user", user.getUsername());
			map.put("end", c.getEnd());
			map.put("start", c.getStart());
			map.put("description", c.getDescription());
			visits.add(map);
		}
		response.setViewName("parkVisits");
		response.addObject("visits", visits);
		
		return response;
	}
}
