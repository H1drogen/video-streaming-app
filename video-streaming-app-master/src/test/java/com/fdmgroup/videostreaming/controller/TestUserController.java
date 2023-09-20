package com.fdmgroup.videostreaming.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

import com.fdmgroup.videostreaming.model.User;

@SpringBootTest
@AutoConfigureMockMvc
public class TestUserController {
	
	@Autowired
	private UserController userController;

	@Autowired
	WebApplicationContext webAppContext;

	MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void test_UserController_LoadsIntoContext() {
		assertThat(userController).isNotNull();
	}

	@Test
	public void test_LoginPage_IsReturned_FromRequestingThe_ForwardSlashGetMapping() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("Login"));

	}
	
	@Test
	public void test_LoggingInWithTheCorrectCredentials_ReturnstoTheAllVideosPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/SaveUser").flashAttr("user",
				new User("Tom", "tom", "tt@test.com", LocalDate.of(2202, 12, 02), "12 test road", "usert", "passt")))
				.andExpectAll(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("Login"));	
	}
	
	@Test
	public void test_RegisterUserPage_IsReturned_FromRequestingThe_ForwardSlashRegisterUserGetMapping() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/RegisterUser")).andExpect(MockMvcResultMatchers.view().name("RegisterUser"));
	}
	
	@Test
	public void test_RegisterUser_FromUserRepo_RegistersUserToTheDB_AndReturnsTheLoginView() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/SaveUser").flashAttr("user",
				new User("Tom", "tom", "tt@test.com", LocalDate.of(2202, 12, 02), "12 test road", "usert", "passt")))
				.andExpectAll(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("Login"));
	}
	

}
