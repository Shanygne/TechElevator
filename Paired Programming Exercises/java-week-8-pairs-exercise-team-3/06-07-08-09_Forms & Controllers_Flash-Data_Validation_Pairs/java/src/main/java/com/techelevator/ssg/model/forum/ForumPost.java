package com.techelevator.ssg.model.forum;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class ForumPost {
	
	private Long id;
	
	@NotBlank(message="Username is required")
	@Size(max=20, message="Username cannot be larger than 20 characters")
	private String username;
	
	@NotBlank(message="Subject is required")
	@Size(min=2, message="Subject must be at least 2 characters")
	private String subject;
	
	@NotBlank(message="Message is required")
	private String message;
	
	private LocalDateTime datePosted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}
}
