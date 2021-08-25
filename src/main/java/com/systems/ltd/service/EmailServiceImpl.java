package com.systems.ltd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systems.ltd.model.Email;
import com.systems.ltd.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	EmailRepository emailRepository;

	@Override
	public void insert(Email email) {
		
		emailRepository.save(email);
		
	}


}
