package com.trio.assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trio.assignment.dto.ContactDTO;
import com.trio.assignment.feign.MailChimpApi;
import com.trio.assignment.service.MailChimpService;

import feign.Response;

@Service
public class MailChimpServiceImpl implements MailChimpService{
	
	@Autowired
	private MailChimpApi mailChimpApi;
	
	@Value("${mailchimp.list-id}")
	private String listId;

	@Override
	public List<ContactDTO> retrieveAllContacts() {
		Response response = mailChimpApi.retrieveContacts(listId);
		return mappingContact(response.body().toString());
	}
	
	public List<ContactDTO> mappingContact(String response){
		String[] listSplit = response.split("\n");
		List<ContactDTO> listContact = new ArrayList<>();
		if(listSplit != null && listSplit.length > 1) {
			for(int i = 1; i < listSplit.length; i++) {
				String[] contactSplit = listSplit[i].replace("[", "").replace("]", "").split(",");
				ContactDTO dto = new ContactDTO();
				dto.setEmail(contactSplit[0].replace("\"", ""));
				dto.setFirstName(contactSplit[1].replace("\"", ""));
				dto.setLastName(contactSplit[2].replace("\"", ""));
				listContact.add(dto);
			}
		}
		return listContact;
	}

}
