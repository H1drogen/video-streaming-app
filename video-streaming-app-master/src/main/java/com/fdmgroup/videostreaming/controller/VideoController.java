package com.fdmgroup.videostreaming.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.videostreaming.model.Video;
import com.fdmgroup.videostreaming.service.VideoService;

import lombok.AllArgsConstructor;

@Controller
public class VideoController {

	private VideoService videoService;

	@Autowired
	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}

	@RequestMapping(value = "/video", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		String idParam = request.getParameter("id");
		Video newVideo = this.videoService.findVideoById(Long.parseLong(idParam)).orElse(null);
		String videoTitleString = newVideo.getTitle();
		String videoLinkString = newVideo.getVideoUrl();
		String videoDescString = newVideo.getDescription();
		model.addAttribute("videoTitle", videoTitleString);
		model.addAttribute("videoLink", videoLinkString);
		model.addAttribute("videoDesc", videoDescString);
		return "test";
	}
	
	@GetMapping("/AllVideos")
	public String returnAllVideos(Model model) {
		List<Video> allVideos = this.videoService.getAllVideos();
		model.addAttribute("videos", allVideos);
		return "AllVideos";
	}
		

	@GetMapping("/AddVideo")
	public String addVideo(Video video) {
		return "AddVideo";
	}

	@PostMapping("/SaveVideo")
	public String saveVideo(@ModelAttribute("video") Video newVideo, BindingResult result, Model model) {
		this.videoService.saveVideo(newVideo);
		return "redirect:/AllVideos";
	}

	@PostMapping("/submitSearch")
	public String getSearchResults(@RequestParam String searchTerm, Model model) {
		model.addAttribute("searchTerm", searchTerm);
		List<Video> foundVideosByTitle = this.videoService.findByTitleContainingIgnoreCase(searchTerm);
		if (foundVideosByTitle.size()>0){
			model.addAttribute("resultsTitle", foundVideosByTitle);
		}
		else {
			model.addAttribute("resultsTitle", foundVideosByTitle);
		}
		List<Video> foundVideosByDesc = this.videoService.findByDescriptionContainingIgnoreCase(searchTerm);
		
		if (foundVideosByDesc.size()>0){
			model.addAttribute("resultsDesc", foundVideosByTitle);
		}
		else {
			model.addAttribute("resultsDesc", foundVideosByTitle);
		}
	
		return "SearchResults";
	}
}
