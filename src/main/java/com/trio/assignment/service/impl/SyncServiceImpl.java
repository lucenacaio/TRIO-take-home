package com.trio.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trio.assignment.dto.ContactDTO;
import com.trio.assignment.dto.SendGridContact;
import com.trio.assignment.service.MailChimpService;
import com.trio.assignment.service.SendGridService;
import com.trio.assignment.service.SyncService;

@Service
public class SyncServiceImpl implements SyncService{
	
	@Autowired
	private MailChimpService mailChimpService;
	
	@Autowired
	private SendGridService sendGridService;

	@Override
	public List<ContactDTO> syncContacts() {
		List<ContactDTO> mailFromChimp = mailChimpService.retrieveAllContacts();
		SendGridContact contacts = new SendGridContact(mailFromChimp);
		sendGridService.sendContacts(contacts);
		return mailFromChimp;
	}

}
