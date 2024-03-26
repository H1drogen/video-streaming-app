package com.fdmgroup.videostreaming.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.videostreaming.service.VideoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("video/")
public class VideoRestController {

	private VideoService videoService;
	
	@PostMapping()
	public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("creator") String creator, @RequestParam("creationDate") LocalDate creationDate) throws IOException {
		videoService.saveVideo(file, title, description, creator, creationDate);
		return ResponseEntity.ok("Video saved successfully.");
	}

	@GetMapping("{title}")
	public ResponseEntity<ByteArrayResource> getVideoByTitle(@PathVariable("title") String title){
	return ResponseEntity.ok(new ByteArrayResource(videoService.getVideo(title).getData()));
	Video(String title, String description, String creator, LocalDateTime creationDate, byte[] data) 
	
	}
	
	@GetMapping("all")
	public ResponseEntity<List<String>> getAllVideoNames(){
		return ResponseEntity.ok(videoService.getAllVideoNames());
	}
	
	
	
	

}
