package com.capstone.nationalparkvisits.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.nationalparkvisits.database.DAO.EventsDAO;
import com.capstone.nationalparkvisits.database.DAO.NatparkDAO;
import com.capstone.nationalparkvisits.database.DAO.UserRolesDAO;
import com.capstone.nationalparkvisits.database.DAO.UsersDAO;
import com.capstone.nationalparkvisits.database.DAO.VisitsDAO;
import com.capstone.nationalparkvisits.database.entities.Events;
import com.capstone.nationalparkvisits.database.entities.Visits;
import com.capstone.nationalparkvisits.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class EventController {
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

	@RequestMapping(value = { "/createEvent" }, method = RequestMethod.GET)
	public ModelAndView createEventPage() {
		log.debug("displaying create event page");
		ModelAndView response = new ModelAndView();

		response.setViewName("createEvent");
		return response;
	}

	@RequestMapping(value = { "/createEvent" }, method = RequestMethod.POST)
	public ModelAndView createEventPost() {
		log.debug("This method submits the event form to the database");
		ModelAndView response = new ModelAndView();
		// TODO create method
		
		return response;
	}
	
	@RequestMapping(value = {}, method = RequestMethod.GET)
	public ModelAndView eventPage(@RequestParam(required = true) Integer id) {
		log.debug("This method creates the event page");
		ModelAndView response = new ModelAndView();
		List<Events> eventsResults = eventsDAO.findByVisitsId(id);
		List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();
		for (Events c: eventsResults) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", c.getId());
			map.put("visitsId", c.getVisitsId());
			map.put("name", c.getName());
			map.put("description", c.getDescription());
			events.add(map);
		}
		response.setViewName("events");
		response.addObject("events", events);		
		return response;
	}
}