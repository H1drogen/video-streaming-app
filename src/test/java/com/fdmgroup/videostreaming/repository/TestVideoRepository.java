package com.fdmgroup.videostreaming.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fdmgroup.videostreaming.model.Video;

@DataJpaTest
public class TestVideoRepository {

	@Autowired
	private VideoRepository videoRepo;
	
	@Test
	public void test_EmployeeRepository_SearchByTitleContaining_ReturnsVideoObjectsWithMatchingTitles() {
		
		Video testVideo = new Video("title of videotest specificexample123", "urlabcedfg", "test description");
		this.videoRepo.save(testVideo);
		assertEquals(testVideo, this.videoRepo.findByTitleContainingIgnoreCase("specificexample123").get(0));
	}
	
	@Test
	public void test_VideoRepository_SearchByDescriptionContaining_ReturnsVideoObjectsWithMatchingDescription() {
		Video testVideo = new Video("title of videotest", "urlabcedfg", "this is my test description specificentry123");
		this.videoRepo.save(testVideo);
		assertEquals(testVideo, this.videoRepo.findByDescriptionContainingIgnoreCase("specificentry123").get(0));
	}
	
	@Test
	public void test_VideoRepository_SearchByDescriptionWithInvalidSearch_ReturnsNoVideoObjects() {
		Video testVideo = new Video("title of videotest", "urlabcedfg", "this is my test description");
		this.videoRepo.save(testVideo);
		assertEquals(true, this.videoRepo.findByTitleContainingIgnoreCase("xxxxxxxxxx").isEmpty());
	}
}
