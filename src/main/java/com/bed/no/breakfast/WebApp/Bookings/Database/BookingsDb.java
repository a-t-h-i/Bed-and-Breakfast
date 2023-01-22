package com.bed.no.breakfast.WebApp.Bookings.Database;
import java.util.*;
import com.bed.no.breakfast.WebApp.Bookings.Booking;

public class BookingsDb{
  private List<Booking> bookings = new ArrayList<Booking>();
  
  public BookingsDb(){
  }
  
  public void addBooking(Booking book){
    this.bookings.add(book);
  }
  
  public List<Booking> getBookings(){
    return this.bookings;
  }
  
  public void removeBooking(Booking book){
    String email = book.getEmail();
    Double price = book.getPrice();
    
    //For loop to find the booking to remove
    for (int i = 0; i != bookings.size(); i++){
      String resEmail = bookings.get(i).getEmail();
      Double resPrice = bookings.get(i).getPrice();
      if (email.equals(resEmail)){
        if(price == resPrice){
          bookings.remove(i);
        }
      }
    }
  }
  
}