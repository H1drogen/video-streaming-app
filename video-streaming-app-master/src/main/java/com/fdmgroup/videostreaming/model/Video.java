package com.fdmgroup.videostreaming.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "videoGen")
	@SequenceGenerator(name = "videoGen", sequenceName = "videoSeq", allocationSize = 1)
	private Long id;
	
	@NotBlank(message = "You must include a title")
	@Column
	private String title;
	
	@NotBlank(message = "You must include a URL")
	@Column 
	private String videoUrl;
	
	@NotBlank(message = "You must add a description")
	@Column
	private String description;
	
	public Video(String title, String videoUrl, String description) {
		
		this.title = title;
		this.videoUrl = videoUrl;
		this.description = description;
		
	}
	
}
