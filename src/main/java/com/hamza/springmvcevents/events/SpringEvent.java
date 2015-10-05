package com.hamza.springmvcevents.events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.hamza.springmvcevents.entities.Subscriber;

public class SpringEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<Subscriber> subscribers = new ArrayList<>();
	
	public SpringEvent(Object source, String aName) {
		super(source);
		name = aName;
	}
	
	public SpringEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public SpringEvent() {
		super("Spring Container");
	}
	
	public void addSubscriber(Subscriber aSubscriber) {
		subscribers.add(aSubscriber);
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Subscriber> getSubscribers() {
		return subscribers;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
