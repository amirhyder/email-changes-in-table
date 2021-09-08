package com.systems.ltd.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.systems.ltd.model.Email;
import com.systems.ltd.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	
	@PostMapping("/email")
	public Email addEmail() throws IOException {
		
		Properties properties = new Properties();
	    InputStream inputStream =getClass().getClassLoader().getResourceAsStream("application.properties");
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
	    
	    return  emailService.insert(email);
	    
	   
	    
	   
		
	}
	
	@GetMapping("/email/{id}")
	public Email findById(@PathVariable Long id)  {
		
		return emailService.findById(id);
	    
		
	}
	
	
	@PostMapping("/emails")
	public Email saveEmail(@RequestBody Email email)  {
		
		return emailService.saveEmail(email);
	    
		
	}
	
	

	
	
	
	
}
