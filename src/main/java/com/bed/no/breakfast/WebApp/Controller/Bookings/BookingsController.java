package com.bed.no.breakfast.WebApp.Controller.Bookings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import com.bed.no.breakfast.WebApp.Bookings.Booking;
import com.bed.no.breakfast.WebApp.User.Person;
import org.springframework.web.servlet.ModelAndView;
import com.bed.no.breakfast.WebApp.StartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.time.LocalDate;
import java.time.Period;
import java.lang.Math; 
import java.util.*;


@Controller


// Booking(String name, String email, LocalDate arrive, Double price)

public class BookingsController{
  @Autowired
  StartServices webService;
  
  //**************Book**************//
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String book(){
	  Person user = webService.getUserDb().getUsers().get(0);//Get first person
	  ModelAndView modelAndView = new ModelAndView();
	  modelAndView.setViewName("book");
	  String name = user.getName();
	  modelAndView.addObject("User", user);
	  return "book";
	}
  
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String bookRoom(@ModelAttribute bookObj bookObject){
	  String user = bookObject.getUser();
	  LocalDate date = bookObject.getDate();
	  Double price = bookObject.getPrice();
	  //Add booking to db
	  addBooking(user, date, price);
	  return "book";//stay on same page
	}
	
	//**************ViewBookings**************//
  @RequestMapping(value = "/change/{date}", method = RequestMethod.GET)
  public String bookings(@PathVariable("date") String date, Model model){
      List<Booking> bookings = webService.getBookingsDb().getBookings();
      Booking booking = null;
      
      for (Booking book: bookings){
        if (book.getDate().toString().equals(date)){
          booking = book;
        }
      }
      
      Double cancelRefund = calculateCancel(booking);
      
      System.out.println("Cancel refund>>>>>>>>>>>>" + cancelRefund);
      model.addAttribute("date", date);
      model.addAttribute("price", Math.round(booking.getPrice() * 100.0)/100.0);
      model.addAttribute("cancelRefund", Math.round(cancelRefund * 100.0)/100.0);
      return "change";
  }
  
  public Double calculateCancel(Booking booking){
	  double refund = 0.0;
	  double bookingPrice = booking.getPrice();
	  LocalDate bookingDate = booking.getDate();
    LocalDate currentDate = LocalDate.now();
    Period difference = currentDate.until(bookingDate);
    int daysTillBooking = difference.getDays();
    
    if(daysTillBooking >= 14){
      refund = bookingPrice;
    }
    
    if (daysTillBooking >= 8 && daysTillBooking <=13){
      refund = bookingPrice - (bookingPrice - (bookingPrice*0.75)); //75% Refund
    }
    
    if (daysTillBooking == 7){
      refund = bookingPrice - (bookingPrice - (bookingPrice*0.5)); //50% refund
    }
    
    if (daysTillBooking >= 3 && daysTillBooking <= 6){
      refund = bookingPrice - (bookingPrice - (bookingPrice*0.25));//25% refund
    }
	  return refund;
  }
  
  public Double calcReschedule(LocalDate date, Booking booking){
    //Cancelling a booking 14 or more days before gives 100% refund
	  //8 to 13 days before gives 75% refund 
	  //7 days before gives 50% refund
	  //3 to 6 days before gives 25% refund
	  //2 days and lower before gives 0% refund
	  
	  double newPrice = 0.0;
	  double bookingPrice = booking.getPrice();
	  LocalDate bookingDate = booking.getDate();
	  
	  return newPrice;
  }
  
  @RequestMapping(value = "/bookings", method = RequestMethod.GET)
  public String showBooked(Model model){
      List<Booking> bookings = webService.getBookingsDb().getBookings();
      model.addAttribute("bookings", bookings);
      return "bookings";  
  }

	
	//**************Change Booking**************//
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public String modify(){
	  //Add logic for based on user interaction on the page
	  //Cancelling a booking 14 or more days before gives 100% refund
	  //8 to 13 days before gives 75% refund 
	  //7 days before gives 50% refund
	  //3 to 6 days before gives 25% refund
	  //2 days and lower before gives 0% refund
	  return "bookings";
	}
	
	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public String change(Model model){
	  return"change";
	}
	
	public boolean addBooking(String user, LocalDate date, Double price){
	  //Check if room is taken
	  for (Booking room: webService.getBookingsDb().getBookings()){
	   
	    if (room.getDate().isEqual(date)){
	      System.out.println("Room taken");
	      return false; //Room taken
	    }
	  }
	  
	  if (webService.getBookingsDb().getBookings().size() <= 4){ //Check if there's less than 5 days left if yes add booking 
	    webService.getBookingsDb().addBooking( new Booking(user, date, price));
	    return true;  
	  }
	  System.out.println("Weekly limit reached");
	  return false;
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