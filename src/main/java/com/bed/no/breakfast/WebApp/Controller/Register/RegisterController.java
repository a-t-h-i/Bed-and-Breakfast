package com.bed.no.breakfast.WebApp.Controller.Register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
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
	public String registerUser(@ModelAttribute Person user, Model model){
	  String name = user.getName();
	  String surname = user.getSurname();
	  String email = user.getEmail();
	  String phone = user.getPhone();
	  String password = user.getPassword();
	
	  if (!userExists(email, password)){
	    addUser(name, surname, email, phone, password);
	    return("login");
	  }
	  model.addAttribute("message", "User already exists!");
	  return("register");
	}
	
	public void addUser(String name, String surname, String email, String phone, String password){
	  Person user = new Person(name, surname, email, phone, password);
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