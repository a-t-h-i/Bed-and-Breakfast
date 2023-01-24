package com.bed.no.breakfast.WebApp.Controller.Login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.bed.no.breakfast.WebApp.User.Person;
import com.bed.no.breakfast.WebApp.StartServices;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class LoginController{
  @Autowired
  StartServices webService;
    //**************Login**************//
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(){
		//This just redirects user to login page
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logUser(@ModelAttribute Login user){
	  String email = user.getEmail();
	  String password = user.getPassword();
	 
		if (userExists(email, password)){
		  saveToSession(email);
		  return "book";  
		}
		
		//Show error message
		return "login";
	}
	
	public void saveToSession(String email){
	  List<Person> users = webService.getUserDb().getUsers();
	  
	  for (int i = 0; i != users.size(); i++){
	    if (users.get(i).getEmail().equals(email)){
	      webService.getSession().logIn(users.get(i)); //Log the user by passing their person object to sessions
	    }
	  }
	}
	
	public void removeFromSession(String email){
	  List<Person> users = webService.getUserDb().getUsers();
	  
	  for (int i = 0; i != users.size(); i++){
	    if (users.get(i).getEmail().equals(email)){
	      webService.getSession().logOut(users.get(i));
	    }
	  }
	}

	public boolean userExists(String email, String password){
	  List<Person> users = webService.getUserDb().getUsers();
	  
	  for (Person user: users){
	    System.out.println(user.getName());
	    if (user.getEmail().equals(email)){
	      if(user.getPassword().equals(password)){
	        return true;
	      }
	    }
	  }
	  return false;
	}
	
	public class Login{
	  private String email ="";
	  private String password ="";
	  
	  public Login(String email, String password){
	    this.email = email;
	    this.password = password;
	  }
	  
	  public String getEmail(){
	    return this.email;
	  }
	  
	  public String getPassword(){
	    return this.password;
	  }
	}
}