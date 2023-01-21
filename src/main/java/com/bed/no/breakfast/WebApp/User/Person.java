package com.bed.no.breakfast.WebApp.User;

public class Person{
  private String name = "";
  private String surname = "";
  private String email = "";
  private String phone = "";
  private String password ="";
  
  public Person(String name, String surname, String email, String phone, String password){
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getSurname(){
    return this.surname;
  }
  
  public String getEmail(){
    return this.email;
  }
  
  public String getPhone(){
    return this.phone;
  }
  
  public String getPassword(){
    return this.password;
  }
}