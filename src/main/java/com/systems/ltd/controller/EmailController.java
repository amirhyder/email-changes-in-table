package com.systems.ltd.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systems.ltd.model.Email;
import com.systems.ltd.repository.EmailRepository;
import com.systems.ltd.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@Autowired
	EmailRepository emailRepository;
	
	
	@PostMapping("/email")
	public void addEmail() throws IOException {
		
		Properties properties = new Properties();
	    InputStream inputStream = 
	    getClass().getClassLoader().getResourceAsStream("application.properties");
	    properties.load(inputStream);
	    
	    Long id=Long.parseLong(properties.getProperty("id"));
	    String from= properties.getProperty("from");
	    String to= properties.getProperty("to");
	    String subject= properties.getProperty("subject");
	    String content= properties.getProperty("content");
	    
	    Email email=new Email();
	    
	    email.setId(id);
    	email.setContent(content);
	    email.setFromEmail(from);
	    email.setSubject(subject);
	    email.setToEmail(to);
	    emailService.insert(email);
	    
	   
	    
	   
		
	}
	
	
	
}
