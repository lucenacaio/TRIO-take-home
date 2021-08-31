package com.trio.assignment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${mailchimp.host}", name = "ApiMailChimp")
public interface MailChimpApi {
	
    @GetMapping(path = "/export/1.0/list/?apikey=${mailchimp.api-key}")
    feign.Response retrieveContacts(@RequestParam String id);

}
