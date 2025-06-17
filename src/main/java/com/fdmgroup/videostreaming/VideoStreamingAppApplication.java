package com.fdmgroup.videostreaming;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fdmgroup.videostreaming.model.User;
import com.fdmgroup.videostreaming.model.Video;
import com.fdmgroup.videostreaming.service.UserService;
import com.fdmgroup.videostreaming.service.VideoService;

@SpringBootApplication
public class VideoStreamingAppApplication {


//	@Autowired
//	private VideoService videoService;

	public static void main(String[] args) {
		SpringApplication.run(VideoStreamingAppApplication.class, args);

	}
}

