package com.fdmgroup.videostreaming.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.videostreaming.model.User;
import com.fdmgroup.videostreaming.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public void saveUser(User confirmedUser) {
		this.userRepo.save(confirmedUser);
	}
	
	public User login(String username, String password) {
		return this.userRepo.findByUsernameAndPassword(username,password);
	}
	
}
