package com.hamza.springmvcevents.events;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hamza.springmvcevents.entities.Subscriber;

@Component
public class SpringEventListener implements ApplicationListener<SpringEvent>{

	@Override
	public void onApplicationEvent(SpringEvent event) {
		
		System.out.println("Received event: " + event);
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, List<Map<String, ?>>> map = restTemplate.getForObject("https://randomuser.me/api/", Map.class);
		
		Map<String, ?> o = map.get("results").get(0);
		Map<String, ?> userMap = (Map<String, ?>) o.get("user");
		
		Map<String, ?> nameMap = (Map<String, ?>) userMap.get("name");
		
		String firstName = (String) nameMap.get("first");
		String lastName = (String) nameMap.get("last");
		String email = (String) userMap.get("email");
		
		Subscriber subscriber = new Subscriber(firstName, lastName, email, event);
		event.addSubscriber(subscriber);
		System.out.println(subscriber);
	}

}
