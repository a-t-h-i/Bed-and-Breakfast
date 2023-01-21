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
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.bed.no.breakfast.WebApp.User.Person;
import com.bed.no.breakfast.WebApp.StartServices;

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
	public String logUser(){
	  String email = "athi@hlubi.com";
	  String password = "hlubi";
		if (userExists(email, password)){
		  return "book";  
		}
		return "login";
	}

	public boolean userExists(String email, String password){
	  List<Person> users = webService.getUserDb().getUsers();
	  
	  for (Person user: users){
	    if (user.getEmail().equals(email)){
	      if(user.getPassword().equals(password)){
	        return true;
	      }
	    }
	  }
	  return false;
	}
}