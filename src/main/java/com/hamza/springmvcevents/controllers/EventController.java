package com.hamza.springmvcevents.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hamza.springmvcevents.entities.Subscriber;
import com.hamza.springmvcevents.events.SpringEvent;
import com.hamza.springmvcevents.services.EventService;

@Controller
@RequestMapping("/")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String eventHome(Model model) {
		
		List<SpringEvent> allEvents = eventService.getAllEvents();
		model.addAttribute("allRegisteredEvents", allEvents);
		model.addAttribute("allSubscribers", getAllSubscribers(allEvents));
		model.addAttribute("event", new SpringEvent(this));
		return "home";
	}

	private List<Subscriber> getAllSubscribers(List<SpringEvent> allEvents) {
		
		List<Subscriber> allSubscribers = new ArrayList<>();
		for (SpringEvent springEvent : allEvents) {
			allSubscribers.addAll(springEvent.getSubscribers());
		}
		return allSubscribers;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public  String addEvent(@ModelAttribute("event") SpringEvent ev) {
		
		eventService.addAndPublishEvent(ev);
		return "redirect:/";
		
	}
	

}
