package com.trio.assignment.service;

import java.util.List;

import com.trio.assignment.dto.ContactDTO;

public interface MailChimpService {
	
	List<ContactDTO> retrieveAllContacts();

}
