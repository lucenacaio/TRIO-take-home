package com.trio.assignment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trio.assignment.dto.SendGridContact;

@FeignClient(url = "${sendgrid.host}", name = "ApiSendGrid")
public interface SendGridApi {

    @PutMapping(path = "/marketing/contacts", headers = {"Authorization=Bearer " + "${sendgrid.api-key}"})
	void syncContacts(@RequestBody SendGridContact contacts);
	
}
