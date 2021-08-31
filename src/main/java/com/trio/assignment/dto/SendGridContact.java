package com.trio.assignment.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendGridContact {
	
	@JsonProperty(value = "contacts")
	private List<ContactDTO> contacts;
	
	public SendGridContact() {
		contacts = new ArrayList<>();
	}
	
	public SendGridContact(List<ContactDTO> contacts) {
		this.contacts = contacts;
	}

	public List<ContactDTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDTO> contacts) {
		this.contacts = contacts;
	}
	
}
