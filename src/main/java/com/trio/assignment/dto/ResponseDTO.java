package com.trio.assignment.dto;

import java.util.List;

public class ResponseDTO {
	
	private Integer syncedContacts;
	private List<ContactDTO> contacts;
	
	public Integer getSyncedContacts() {
		return syncedContacts;
	}
	public void setSyncedContacts(Integer syncedContacts) {
		this.syncedContacts = syncedContacts;
	}
	public List<ContactDTO> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactDTO> contacts) {
		this.contacts = contacts;
	}
	
}
