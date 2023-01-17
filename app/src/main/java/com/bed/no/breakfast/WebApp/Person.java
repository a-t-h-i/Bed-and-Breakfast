package com.bed.no.breakfast.WebApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

Public class Person{
	private final string name = "";
	private final String surname = "";
	private final String id = "";
	private final String email = "";
	//Default constructor
	public Person(String name, String surname, String id, String email){
		//initialize values
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.email = email;
	}

	//Get name
	public String getName(){
	return this.name;
	}

	//Get surname
	public String getSurname(){
	return this.surname;
	}

	//Get id
	public String getId(){
	return this.id;
	}
	
	//Get email
	public String getEmail(){
	  return this.email;
	}
}
