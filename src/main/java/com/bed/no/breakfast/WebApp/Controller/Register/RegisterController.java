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

@Controller
public class RegisterController{
  //**************Register**************//
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(){
	  //This just redirects to registration page
	  return("register");//Take user back to loginPage
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(){
	  
	  //If user already exists redirect to register page and notify
	  //If user entered incorrect details redirect to register page and notify
	  
	  //Add code for saving user to database of users and redirect to login page if the user met the above requirements
	  return("login");//Take user back to loginPage after registration
	}
}