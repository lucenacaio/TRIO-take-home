package com.trio.assignment.service;

import com.trio.assignment.dto.SendGridContact;

public interface SendGridService {

	void sendContacts(SendGridContact contacts);
	
}
