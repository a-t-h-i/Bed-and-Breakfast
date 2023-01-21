package com.bed.no.breakfast.WebApp.Controller;

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
public class WebController{
  @RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(){
		//This just redirects user to login page
		return "login";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(){
		// Takes user to login page if an error happens. I know this is not how it's done but time is not on my side...
		return "login";
	}
}
