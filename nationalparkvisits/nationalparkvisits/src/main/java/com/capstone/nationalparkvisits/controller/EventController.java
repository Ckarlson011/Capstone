package com.capstone.nationalparkvisits.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.capstone.nationalparkvisits.database.entities.Events;
import com.capstone.nationalparkvisits.database.entities.Natpark;
import com.capstone.nationalparkvisits.database.entities.Users;
import com.capstone.nationalparkvisits.database.entities.Visits;
import com.capstone.nationalparkvisits.form.NewEventForm;
import com.capstone.nationalparkvisits.form.SignupForm;
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
	public ModelAndView createEventPost(@Valid NewEventForm form, BindingResult bindingResult) {
		log.debug("This method submits the event form to the database");
		ModelAndView response = new ModelAndView();
		response.setViewName("createEvent");
		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getObjectName() + " : " + e.getDefaultMessage());
		}
		if (!bindingResult.hasErrors()) {
			Events event = new Events();
			event.setDescription(form.getDescription());
			event.setName(form.getName());
			event.setVisitsId(form.getVisitId());
			eventsDAO.save(event);
			response.setViewName("index");
		}
		return response;
	}
	
	@RequestMapping(value = {"/events"}, method = RequestMethod.GET)
	public ModelAndView eventPage(@RequestParam(required = true) Integer id) {
		log.debug("This method creates the event page");
		ModelAndView response = new ModelAndView();
		List<Events> eventsResults = eventsDAO.findByVisitsId(id);
		List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();
		for (Events c: eventsResults) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", c.getId());
			Visits visit = visitsDAO.findById(c.getVisitsId());
			Natpark park = natparkDAO.findById(visit.getNatparksId());
			map.put("natpark", park.getName());
			Users user = usersDAO.findById(visit.getUsersId());
			map.put("user", user.getUsername());
			map.put("start", visit.getStart());
			map.put("end", visit.getEnd());
			map.put("name", c.getName());
			map.put("description", c.getDescription());
			events.add(map);
		}
		response.setViewName("events");
		response.addObject("events", events);
		return response;
	}
}
