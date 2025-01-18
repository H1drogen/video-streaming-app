package com.fdmgroup.videostreaming.repository;

import org.springframework.stereotype.Repository;

import com.fdmgroup.videostreaming.model.Video;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
	
	Optional<Video> findVideoById(Long id);

	List<Video> findByTitleContainingIgnoreCase(String searchTerm);
	
	List<Video> findByDescriptionContainingIgnoreCase(String searchTerm);

}
