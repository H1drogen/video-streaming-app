package com.fdmgroup.videostreaming.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.videostreaming.exceptions.VideoNotFoundException;
import com.fdmgroup.videostreaming.model.Video;
import com.fdmgroup.videostreaming.repository.VideoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VideoServiceImp implements VideoService {
	
	private VideoRepository videoRepo;

	@Override
	public void saveVideo(Video video) {
		this.videoRepo.save(video);
		
	}

	@Override
	public List<Video> getAllVideos() {
		return this.videoRepo.findAll();

	}

	@Override
	public Optional<Video> findVideoById(Long id) {
		return this.videoRepo.findById(id);
	}

	@Override
	public List<Video> findByTitleContainingIgnoreCase(String searchTerm) {
		return this.videoRepo.findByTitleContainingIgnoreCase(searchTerm);
	}

	@Override
	public List<Video> findByDescriptionContainingIgnoreCase(String searchTerm) {
		return this.videoRepo.findByDescriptionContainingIgnoreCase(searchTerm);

	}
}
