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
	public Email insert(Email email) {
		
		return emailRepository.save(email);
		
	}

	@Override
	public Email findById(Long id) {
		// TODO Auto-generated method stub
		return emailRepository.findById(id).get();
	}

	@Override
	public Email saveEmail(Email email) {
		// TODO Auto-generated method stub
		return emailRepository.save(email);
	}


}
