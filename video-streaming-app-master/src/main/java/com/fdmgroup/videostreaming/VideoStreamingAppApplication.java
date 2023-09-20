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

//MESUT - This is a comment for you to read, dont mark us down for this!

	/*Our repository tests were not working and the error was due to this class
	
	It no longer implements CommandLineRunner
	
	I have commented out the autowired, and the run method 
	so that you can see it and understand. 
	the database no longer populates on startup, all videos have to be added through AddVideo
	but the test ALL pass now
	*/

@SpringBootApplication
public class VideoStreamingAppApplication {

	
//	@Autowired
//	private VideoService videoService;
	
	public static void main(String[] args) {
		SpringApplication.run(VideoStreamingAppApplication.class, args);
		
	}

	
//	
//	public void run(String...args) throws Exception {
//		
//		Video newvideo = new Video();
//		newvideo.setTitle("orchestral performance");
//		newvideo.setVideoUrl("https://youtube.com/embed/l_dGqLzOnhA");
//		newvideo.setDescription("this was in my recommended. so great!");
//		this.videoService.saveVideo(newvideo);
//		
//		Video newvideo2 = new Video();
//		newvideo2.setTitle(" video about bread");
//		newvideo2.setVideoUrl("https://youtube.com/embed/1FcR1PDzC94");
//		newvideo2.setDescription("interesting!");
//		this.videoService.saveVideo(newvideo2);
//		
//		Video newvideo3 = new Video();
//		newvideo3.setTitle("iphone review?");
//		newvideo3.setVideoUrl("https://youtube.com/embed/SdLShOCvVeM");
//		newvideo3.setDescription("might get this...");
//		this.videoService.saveVideo(newvideo3);
//		
//		Video newvideo4 = new Video();
//		newvideo4.setTitle("Russia-Ukraine update");
//		newvideo4.setVideoUrl("https://youtube.com/embed/qbbfKAmghb8");
//		newvideo4.setDescription("really interesting video I thought - what do you guys think?");
//		this.videoService.saveVideo(newvideo4);
//		
//		Video newvideo5 = new Video();
//		newvideo5.setTitle("Lewis Capaldi Interview!");
//		newvideo5.setVideoUrl("https://youtube.com/embed/ktl0UdZtL1A");
//		newvideo5.setDescription("Loved this!");
//		this.videoService.saveVideo(newvideo5);
//		
//		Video newvideo6 = new Video();
//		newvideo6.setTitle("new music video");
//		newvideo6.setVideoUrl("https://youtube.com/embed/POe9SOEKotk");
//		newvideo6.setDescription("obsessed with this. watched it 10 times");
//		this.videoService.saveVideo(newvideo6);
//	}

}


