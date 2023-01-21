package com.bed.no.breakfast.WebApp.User.Database;
import com.bed.no.breakfast.WebApp.User.Person;
import java.util.*;

public class UserDatabase{
  private List<Person> users = new ArrayList<Person>(); //Create empty list of users
  public UserDatabase(){
  }
  
   //For adding users to db
  public void addUser(Person user){
    this.users.add(user);
  }
  
  public List<Person> getUsers(){
    return this.users;
  }
  //For now that is all I need for basic functionality
}