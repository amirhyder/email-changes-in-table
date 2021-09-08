package com.systems.ltd.service;

import com.systems.ltd.model.Email;

public interface EmailService {

	public Email insert(Email email);

	public Email findById(Long id);

	public Email saveEmail(Email email);
	
	
	
	
	
	
}
