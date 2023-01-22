package com.bed.no.breakfast.WebApp.Controller.Bookings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.bed.no.breakfast.WebApp.Bookings.Booking;
import com.bed.no.breakfast.WebApp.User.Person;
import java.time.LocalDate;

@Controller


// Booking(String name, String email, LocalDate arrive, Double price)

public class BookingsController{
  //**************Book**************//
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String book(){
	  return("book");//Goto book room view
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String bookRoom(@ModelAttribute bookObj bookObject){
	  String user = bookObject.getUser();
	  Double price = bookObject.getPrice();
	  LocalDate date = bookObject.getDate();
	  
	  System.out.println("Price: " + price);
	  System.out.println("Date: " + date);
	  //If the room is already booked for that date notify the user and redirect to book page
	  //If the user selects more than 5 days notify the user and redirect to book page 
	  //Add code for saving  the booking to the bookings database if the user met the above requirements
	  return("bookings");//Take user to bookings view
	}
	
	//**************ViewBookings**************//
	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public String bookings(){
	  //If there are no bookings made then just show that there are no bookings
	  //If user selects on change booking redirect to modify bookings page
	  return("bookings");//Take user to bookings view
	}
	
	@RequestMapping(value = "/bookings", method = RequestMethod.POST)
	public String gotoModify(){
	  //If there are no bookings made then just show that there are no bookings
	  //If user selects on change booking redirect to modify bookings page
	  return("change");//Take user to modify view
	}
	
	//**************Change Booking**************//
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String modify(){
	  return "bookings";
	}
	
	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public String change(){
	  //Add logic for based on user interaction on the page
	  //Cancelling a booking 14 or more days before gives 100% refund
	  //8 to 13 days before gives 75% refund 
	  //7 days before gives 50% refund
	  //3 to 6 days before gives 25% refund
	  //2 days and lower before gives 0% refund
	  return"change";//After succesful modification take user to bookings page
	}
	
	class bookObj{
	  private LocalDate date = null;
	  private Double price = null;
	  private String user = "";
	  
	  public bookObj(LocalDate date, Double price, String user){
	    this.date = date;
	    this.price = price;
	    this.user = user;
	  }
	  
	  public LocalDate getDate(){
	    return this.date;
	  }
	  
	  public Double getPrice(){
	    return this.price;
	  }
	  
	  public String getUser(){
	    return this.user;
	  }
	}
	
}