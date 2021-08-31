package com.trio.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.trio.assignment.dto.SendGridContact;
import com.trio.assignment.exception.SyncException;
import com.trio.assignment.feign.SendGridApi;
import com.trio.assignment.service.SendGridService;

import feign.FeignException;

@Service
public class SendGridServiceImpl implements SendGridService {

	@Autowired
	private SendGridApi sendGridApi;
	
	@Override
	public void sendContacts(SendGridContact contacts) {
		try {			
			sendGridApi.syncContacts(contacts);
		} catch (FeignException.Unauthorized e) {
			throw new SyncException(HttpStatus.UNAUTHORIZED);
		}
	}

}
