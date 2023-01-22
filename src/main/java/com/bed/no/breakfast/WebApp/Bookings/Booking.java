package com.bed.no.breakfast.WebApp.Bookings;
import java.util.*;
import java.time.LocalDate;
public class Booking{
  //This is a booking class that'll be used to create booking objects
  private String email = ""; //Email of Person
  private LocalDate arrive = null; //Date off arriving at bnb
  private Double price = 0.0;
  
  public Booking(String email, LocalDate arrive, Double price){
    this.email = email;
    this.arrive = arrive;
    this.price = price;
  }
  
  public void changeDate(LocalDate arrive){
    this.arrive = arrive;
  }
  
  public String getEmail(){
    return this.email;
  }
  
  public Double getPrice(){
    return this.price;
  }
  
  public LocalDate getDate(){
    return this.arrive;
  }
}