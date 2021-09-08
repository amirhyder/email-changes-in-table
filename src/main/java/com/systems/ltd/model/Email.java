package com.systems.ltd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Entity

public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String toEmail;
	private String fromEmail;
	private String content;
	private String subject;
	
	
	
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Email(Long id, String toEmail, String fromEmail, String content, String subject) {
		super();
		this.id = id;
		this.toEmail = toEmail;
		this.fromEmail = fromEmail;
		this.content = content;
		this.subject = subject;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
