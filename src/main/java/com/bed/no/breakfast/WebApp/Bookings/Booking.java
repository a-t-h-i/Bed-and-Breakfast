package com.bed.no.breakfast.WebApp.Bookings;
import java.util.*;

public class Booking{
  //This is a booking class that'll be used to create booking objects
  private String name = "";
  private String email = ""; //Email of Person
  private Date arrive = null; //Date off arriving at bnb
  private Date leave = null; //Date of leaving
  
  public Booking(String name, String email, Date arrive, Date leave){
    this.name = name;
    this.email = email;
    this.arrive = arrive;
    this.leave = leave;
  }
  
  public void changeDate(Date arrive, Date leave){
    this.arrive = arrive;
    this.leave = leave;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getEmail(){
    return this.email;
  }
}