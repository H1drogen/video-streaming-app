package com.fdmgroup.videostreaming.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.videostreaming.model.User;
import com.fdmgroup.videostreaming.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String goToLogin() {
		return "Login";
	}

	@PostMapping("/login")
	public String loginauthentication(@ModelAttribute("user") User user, Model model) {
		User loginUser = this.userService.login(user.getUsername(), user.getPassword());
		if (loginUser == null) {
			return "Login";
		} else {
			return "redirect:/AllVideos";
		}
	}

	@GetMapping("/RegisterUser")
	public String RegisterUser(User newUser) {
		return "RegisterUser";
	}

	@PostMapping("/SaveUser")
	public String saveUser(@Valid User newUser, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.err.println("You have an error!");
			return "RegisterUser";
		}
		this.userService.saveUser(newUser);
		return "Login";
	}
}
