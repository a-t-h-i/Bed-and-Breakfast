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
  
  public void removeBooking(Booking book){
    String email = book.getEmail();
    String name = book.getName();
    
    //For loop to find the booking to remove
    for (int i = 0; i != bookings.size(); i++){
      String resName = bookings.get(i).getName();
      String resEmail = bookings.get(i).getEmail();
      
      if (name.equals(resName)){
        if(email.equals(resEmail)){
          bookings.remove(i);
        }
      }
    }
  }
  
}