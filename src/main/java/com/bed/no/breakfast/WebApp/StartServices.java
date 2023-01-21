package com.bed.no.breakfast.WebApp;
import org.springframework.stereotype.Service;
import com.bed.no.breakfast.WebApp.Bookings.Database.BookingsDb;
import com.bed.no.breakfast.WebApp.User.Database.UserDatabase;

//This class just starts the required services for the WebApp
@Service
public class StartServices{
  private static UserDatabase userDb = null;
  private static BookingsDb bookDb = null;
  
  static {
    userDb = new UserDatabase();
    bookDb = new BookingsDb();
  }
  
  public UserDatabase getUserDb(){
    return userDb;
  }
  
  public BookingsDb getBookingsDb(){
    return bookDb;
  }
}