package com.bed.no.breakfast.WebApp;

import java.util.*;
import com.bed.no.breakfast.WebApp.User.Person;

public class UserSessions{
  private List<Person> loggedUsers = new ArrayList<Person>();
  
  public UserSessions(){
  }
  
  public void logIn(Person user){
    this.loggedUsers.add(user);  
  }
  
  public void logOut(Person user){
    for (int i = 0; i != loggedUsers.size(); i++){
      if (userFound(user, loggedUsers.get(i))){
        loggedUsers.remove(i);
      }
    }
  }
  
  public List<Person> getUsers(){
    return this.loggedUsers;
  }
  
  private boolean userFound(Person user, Person loggedUser){
    return ((user.getEmail().equals(loggedUser.getEmail())) && (user.getPassword().equals(loggedUser.getPassword())));
  }
}