package com.fdmgroup.videostreaming.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;


import com.fdmgroup.videostreaming.model.Video;


@SpringBootTest
@AutoConfigureMockMvc
class TestVideoController {
	
	@Autowired
	private VideoController videoController;
	
	@Autowired
	WebApplicationContext webAppContext;

	MockMvc mockMvc;
	

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void test_VideoController_LoadsIntoContext() {
		assertThat(videoController).isNotNull();
	}

	@Test
	public void test_AllVideosPage_IsReturned_FromRequestingThe_ForwardSlashAllVideosGetMapping() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/AllVideos")).andExpect(MockMvcResultMatchers.view().name("AllVideos"));
	}
	
	@Test
	public void test_AddVideoPage_IsReturned_FromRequestingThe_ForwardSlashAddVideoGetMapping() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/AddVideo")).andExpect(MockMvcResultMatchers.view().name("AddVideo"));
	}
	
	
	@Test
	public void test_SearchMethod_IsOK_AndReturns_SearchResults() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/submitSearch").param("searchTerm", "testsearch"))
		.andExpectAll(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("SearchResults"));
	}

	@Test
	public void test_SaveVideo_onAddVIdeo_ReturnsTheAllVideosPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/SaveVideo").flashAttr("video",
				new Video("title of videotest", "urlabcedfg", "test description")))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/AllVideos"));
	}

}
