package com.hamza.springmvcevents.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.hamza.springmvcevents.entities.Subscriber;
import com.hamza.springmvcevents.events.SpringEvent;

@Service
public class EventService implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher publisher;
	
	List<SpringEvent> allEvents = new ArrayList<>();
	
	public List<SpringEvent> getAllEvents() {
		return allEvents;
	}
	
	public List<Subscriber> getAllSubscribersForEvent(SpringEvent event) {
		return event.getSubscribers();
	}
	
	public void addAndPublishEvent(SpringEvent ev) {
		allEvents.add(ev);
		publisher.publishEvent(ev);
		// TODO: Publish the event
	}
	
	@PostConstruct
	public void createInitialEvents() {
		SpringEvent event = new SpringEvent(this, "BJJ Seminar");
		addAndPublishEvent(event);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}
	
}
