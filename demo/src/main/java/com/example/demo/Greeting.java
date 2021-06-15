package com.example.demo;

//POJO - Plain Old Java Object
//Greeting class is where data stored

public class Greeting {

	private final long id;
	private final String content;
	
	public Greeting (long id,String content) {
		this.id= id;
		this.content = content;
	}
	
	public long getID() {
		return id;		
	}
	
	public String getContent() {
		return content;
	}
	
}
