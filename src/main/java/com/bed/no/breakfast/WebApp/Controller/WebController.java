package com.bed.no.breakfast.WebApp.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;


@Controller
public class WebController{
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(){
		//This just redirects user to login page
		return "login";
	}
	
  //**************Login**************//
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(){
		//This just redirects user to login page
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logUser(){
		//Need to add logic to verify user details
		return "book";
	}
	
	
// 	("/foo")
//     public String showPage(@ModelAttribute("someBean") SomeBean bean) {

//         System.out.println("Date planted: " + bean.getDatePlanted()); //in reality, you'd use a logger instead :)
//         return "redirect:someOtherPage";
//     }
	
	//**************Register**************//
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(){
	  //This just redirects to registration page
	  return("register");//Take user back to loginPage
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(){
	  
	  //If user already exists redirect to register page and notify
	  //If user entered incorrect details redirect to register page and notify
	  
	  //Add code for saving user to database of users and redirect to login page if the user met the above requirements
	  return("login");//Take user back to loginPage after registration
	}
	
	//**************Book**************//
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String book(){
	  return("book");//Goto book room view
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String bookRoom(){
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
	  return("modify");//Take user to modify view
	}
	
	//**************Change Booking**************//
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(){
	  return "modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String change(){
	  //Add logic for based on user interaction on the page
	  //Cancelling a booking 14 or more days before gives 100% refund
	  //8 to 13 days before gives 75% refund 
	  //7 days before gives 50% refund
	  //3 to 6 days before gives 25% refund
	  //2 days and lower before gives 0% refund
	  return"bookings";//After succesful modification take user to bookings page
	}
}
