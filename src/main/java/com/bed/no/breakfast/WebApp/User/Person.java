package com.bed.no.breakfast.WebApp.User;

public class Person{
  private String name = "";
  private String surname = "";
  private String idNum = "";
  private String email = "";
  private String phone = "";
  
  public Person(String name, String surname, String idNum, String email, String phone){
    this.name = name;
    this.surname = surname;
    this.idNum = idNum;
    this.email = email;
    this.phone = phone;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getSurname(){
    return this.surname;
  }
  
  public String getId(){
    return this.idNum;
  }
  
  public String getEmail(){
    return this.email;
  }
  
  public String getPhone(){
    return this.phone;
  }
}