package com.codewarrior.userdemo.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewarrior.userdemo.model.Address;
import com.codewarrior.userdemo.model.Company;
import com.codewarrior.userdemo.model.Users;

@Service
public class RestClientService {
	
	private final RestTemplate restTemplate;
	
	
	private final String GET_ALL_URL = "https://jsonplaceholder.typicode.com/users";
	
	@Autowired
    public RestClientService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
	
	public List<Users> getAllUsers(){
        return Arrays.stream(restTemplate.getForObject(GET_ALL_URL,Users[].class, Company.class, Address.class)).collect(Collectors.toList());
    }

}
