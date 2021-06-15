package com.example.demo;

import org.springframework.stereotype.Component;

@Component     //to convert pojo to component 
public class GreetingComponent {

	// a pojo
	public String getMessage() {
		return"Hello from GreetingComponent";
	}
		
}
