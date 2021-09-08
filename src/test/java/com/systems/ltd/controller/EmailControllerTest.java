package com.systems.ltd.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.systems.ltd.model.Email;
import com.systems.ltd.service.EmailService;

@WebMvcTest(EmailController.class)
class EmailControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EmailService emailService;
	
	Email email;
	
	@BeforeEach
	void setUp() throws Exception {
		
		email=new Email();
		
		email.setContent("content");
		email.setSubject("subject");
		email.setFromEmail("amir@gmail.com");
		email.setToEmail("amir1998@gmail.com");
		email.setId(1L);
	}

	@Test
	void testSaveEmail() throws Exception {
		
		Email inputEmail=new Email();
		inputEmail.setContent("content");
		inputEmail.setSubject("subject");
		inputEmail.setFromEmail("amir@gmail.com");
		inputEmail.setToEmail("amir1998@gmail.com");
		
		Mockito.when(emailService.saveEmail(inputEmail)).thenReturn(email);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/emails")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"toEmail\":\"amir@gmai.com\",\r\n"
						+ "    \"fromEmail\":\"amir1998@gmail.com\",\r\n"
						+ "    \"subject\":\"subject\",\r\n"
						+ "    \"content\":\"content\"\r\n"
						+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
