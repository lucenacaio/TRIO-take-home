package com.trio.assignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDTO {
	
	@JsonProperty(value = "first_name")
	private String firstName;
	
	@JsonProperty(value = "last_name")
	private String lastName;
	
	@JsonProperty(value = "email")
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
