package com.trio.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trio.assignment.dto.ContactDTO;
import com.trio.assignment.dto.ResponseDTO;
import com.trio.assignment.exception.SyncException;
import com.trio.assignment.service.SyncService;

@RestController
@RequestMapping("contacts")
public class ContactsController {
	
	@Autowired
	SyncService syncService;
	
	@GetMapping(path = "sync" ,produces = "application/json")
	public ResponseEntity<ResponseDTO> syncContacts() {
		ResponseDTO response = new ResponseDTO();
		try {
			List<ContactDTO> contactsSynced = syncService.syncContacts();
			response.setContacts(contactsSynced);
			response.setSyncedContacts(contactsSynced.size());			
		}catch (SyncException ex) {
			return ResponseEntity.status(ex.getStatus()).body(response);
		}
		return ResponseEntity.ok().body(response);
	}


}
