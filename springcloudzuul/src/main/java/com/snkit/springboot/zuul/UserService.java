package com.snkit.springboot.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	@Autowired
	private RestTemplate restTemplate;
	public String getUser(){
		
		ResponseEntity<String> resp = restTemplate.exchange("http://custaddress-service/getUsers",HttpMethod.GET,null,String.class);
		
	
		
		return resp.getBody();
		
		
		
		
	}

}
