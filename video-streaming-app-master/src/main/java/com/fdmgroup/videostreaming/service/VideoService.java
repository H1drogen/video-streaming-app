package com.fdmgroup.videostreaming.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.videostreaming.model.Video;

@Service
public interface VideoService {
	void saveVideo(Video video);
	
	Optional<Video> findVideoById(Long id);
	
	List<Video> getAllVideos();
	
	List<Video> findByTitleContainingIgnoreCase(String searchTerm);
	
	List<Video> findByDescriptionContainingIgnoreCase(String searchTerm);
	
}
