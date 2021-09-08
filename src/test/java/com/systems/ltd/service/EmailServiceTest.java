package com.systems.ltd.service;





import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.systems.ltd.model.Email;
import com.systems.ltd.repository.EmailRepository;

@SpringBootTest
class EmailServiceTest {
	
	@Autowired
	EmailService emailService;
	
	@MockBean
	EmailRepository emailRepository;
	

	@BeforeEach
	void setUp() throws Exception {
		
		Email email=new Email();
		
		Properties properties = new Properties();
	    InputStream inputStream =getClass().getClassLoader().getResourceAsStream("application.properties");
	    properties.load(inputStream);
	    
	    Long id=Long.parseLong(properties.getProperty("id"));
	    String from= properties.getProperty("from");
	    String to= properties.getProperty("to");
	    String subject= properties.getProperty("subject");
	    String content= properties.getProperty("content");
	    
	    email.setId(id);
    	email.setContent(from);
	    email.setFromEmail(to);
	    email.setSubject(subject);
	    email.setToEmail(content);
	    
	   
	    
	    Mockito.when(emailRepository.save(email)).thenReturn(email);
	    
	    
	}
	


	@Test
	public void readPropertiesFileAndThenUpdateInDatabase() throws IOException {
		
		Properties properties = new Properties();
	    InputStream inputStream =getClass().getClassLoader().getResourceAsStream("application.properties");
	    properties.load(inputStream);
	    
		
	    
	    Email email=new Email();
	    
	    Long id=Long.parseLong(properties.getProperty("id"));
	    String from= properties.getProperty("from");
	    String to= properties.getProperty("to");
	    String subject= properties.getProperty("subject");
	    String content= properties.getProperty("content");
	    
	    email.setId(id);
    	email.setContent(content);
	    email.setFromEmail(from);
	    email.setSubject(subject);
	    email.setToEmail(to);
	    
	    
	    
	    Email email2= emailService.insert(email);
	    
	    assertEquals(email.getContent(), email2.getContent());
	    
	}


}
