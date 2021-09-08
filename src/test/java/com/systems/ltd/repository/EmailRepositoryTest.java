package com.systems.ltd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.systems.ltd.model.Email;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class EmailRepositoryTest {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@Test
	void emailIsReturnedWhenIdIsGiven() {
		Email email=new Email();
		email.setId(2L);
    	email.setContent("this is content for second email");
	    email.setFromEmail("amirhyderkaloi@gmail.com");
	    email.setSubject("this is subject");
	    email.setToEmail("amirhyder1998@gmail.com");
	    
	    testEntityManager.persist(email);
		Email email1=emailRepository.findById(2L).get();
		
		assertEquals(email1.getContent(),"this is content for second email");
		
	}

}
