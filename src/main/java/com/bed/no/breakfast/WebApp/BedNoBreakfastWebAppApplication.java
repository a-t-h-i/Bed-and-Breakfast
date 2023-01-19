package com.bed.no.breakfast.WebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;
  
@SpringBootApplication
public class BedNoBreakfastWebAppApplication {

	public static void main(String[] args) {
      SpringApplication.run(BedNoBreakfastWebAppApplication.class, args);
      }
}
            
