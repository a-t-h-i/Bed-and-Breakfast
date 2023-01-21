package com.bed.no.breakfast.WebApp.Controller.Register;

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
import java.util.*;


@Controller
public class RegisterController{
  @Autowired
  StartServices webService;
  
  //**************Register**************//
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(){
	  //This just redirects to registration page
	  return("register");//Take user back to loginPage
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(){
	  String name = "Athenkosi";
	  String surname = "Hlubi";
	  String idNum = "9709279510088";
	  String email = "athi@hlubi.com";
	  String phone = "0764802238";
	  String password = "admin";
	  
	  if (!userExists(email, password)){
	    addUser(name, surname, idNum, email, phone, password);
	    return("login");
	  }
	  return("register");
	}
	
	public void addUser(String name, String surname, String idNum, String email, String phone, String password){
	  Person user = new Person(name, surname, idNum, email, phone, password);
	  webService.getUserDb().addUser(user);
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