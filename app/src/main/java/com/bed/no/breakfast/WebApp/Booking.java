package com.bed.no.breakfast.WebApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bed.no.breakfast.Person;

public class Booking{
	String bookingDate = "";//This has to be of date type  
	String departDate = ""; //**
	Person booker = null;
	
	public Booking(String bookDate, String departDate, Person booker){
		this.bookingDate = bookDate;
		this.departDate = departDate;
		this.booker = booker;
	}

	//Get date of booking
	public String getBookedDate(){
		return this.bookingDate;
	}
	//Get person who booked
	public Person getBooker(){
		return this.booker;
	}

	//get departure date
	public String getDeparture(){
		return this.departDate;
	}

