package com.fdmgroup.videostreaming.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fdmgroup.videostreaming.model.User;

@DataJpaTest
public class TestUserRepository {

	@Autowired
	private UserRepository UserRepo;
	
	@Test
	public void test_findByUsernameAndPassword_ReturnsMatchingDetails() {
		User user1 = new User("Tom", "tom", "tester@test.com", LocalDate.of(2202, 12, 02), "12 test road", "username", "passt");
		User user2 = new User("Tom", "tom", "tt@test.com", LocalDate.of(2202, 12, 02), "12 test road", "usert", "passtorian");
		this.UserRepo.save(user1);
		this.UserRepo.save(user2);
		assertEquals(user2.getUserId(), this.UserRepo.findByUsernameAndPassword("usert", "passtorian").getUserId());	
	}
	
}
