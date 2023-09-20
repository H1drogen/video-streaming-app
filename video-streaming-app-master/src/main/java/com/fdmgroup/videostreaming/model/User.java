package com.fdmgroup.videostreaming.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity(name = "userTable")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGen")
	@SequenceGenerator(name = "userGen", sequenceName = "userSeq", allocationSize = 1)
	private int userId;
	
	@NotBlank(message = "First Name field cannot be empty")
	@Size(min = 2, max = 30, message = "First Name must be between 2 - 30 chars long")
	@Column(length = 30, nullable = false)
	private String firstName;
	
	@NotBlank(message = "last Name field cannot be empty")
	@Size(min = 2, max = 40, message = "last Name must be between 2 - 40 chars long")
	@Column(length = 40, nullable = false)
	private String lastName;
	
	@NotBlank(message = "Email field cannot be empty")
	@Size(min = 2, max = 100, message = "Email must be between 2 - 100 chars long")
	@Column(length = 100, nullable = false)
	private String email;
	
	@NotNull(message = "A user must have a Date Of Birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@NotBlank(message = "username field cannot be empty")
	@Size(min = 2, max = 30, message = "username must be between 2 - 30 chars long")
	@Column(length = 30, nullable = false)
	private String username;
	
	@NotBlank(message = "password field cannot be empty")
	@Size(min = 2, max = 30, message = "password must be between 2 - 30 chars long")
	@Column(length = 30, nullable = false)
	private String password;
	
	private String accountType;
	
	public User(String firstName, String lastName, String email,
			LocalDate dateOfBirth, String accountType, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.accountType = accountType;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
	}

	public User(
			@NotBlank(message = "username field cannot be empty") @Size(min = 2, max = 30, message = "username must be between 2 - 30 chars long") String username,
			@NotBlank(message = "password field cannot be empty") @Size(min = 2, max = 30, message = "password must be between 2 - 30 chars long") String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
