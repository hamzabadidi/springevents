package com.hamza.springmvcevents.entities;

import com.hamza.springmvcevents.events.SpringEvent;

public class Subscriber {
	
	private String firstName;
	private String lastName;
	private String email;
	private SpringEvent event;
	
	public Subscriber(String aFirstName, String alastName, String anEmail, SpringEvent anEvent) {
		firstName = aFirstName;
		lastName = alastName;
		email = anEmail;
		event = anEvent;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public SpringEvent getEvent() {
		return event;
	}

	public void setEvent(SpringEvent event) {
		this.event = event;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + email + ") subscribed for event: " + event;
	}
}
