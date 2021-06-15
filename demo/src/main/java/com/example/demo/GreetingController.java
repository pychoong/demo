package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//add annotation to GreetingController to convert it to a rest controller component
@RestController

public class GreetingController {

	private static final String template = "Hello,%s!";
	private final AtomicLong counter = new AtomicLong();
	
	//define a GreetingComponent variable without initialization
	private GreetingComponent g;
	
	//inject/initialize GreetingComponent in the constructor
	@Autowired
	public GreetingController(GreetingComponent g) {
		this.g = g;				
	}
	
	//test the greeting component
	@GetMapping("/testGreeting")
	public ResponseEntity<String> getMessage() {
	     return ResponseEntity.ok(g.getMessage());
	     
	}
	
	@GetMapping("/greeting") 
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template,name));
	}
	
		
	@GetMapping("/add/{num1}/{num2}")
	public Integer addTwoNumbers(@PathVariable(value = "num1") Integer num1,
//	public int addTwoNumbers(@PathParam int num1, @RequestParam int num2) {		
		@PathParam(value = "num2") Integer num2){
		return num1 + num2;
	}
	
	
	
}
