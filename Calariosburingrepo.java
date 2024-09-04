package com.myfitness.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfitness.Entity.User;
import com.myfitness.Entity.caloirburing;
import com.myfitness.Entity.caloirintake;

public interface Calariosburingrepo extends JpaRepository<caloirburing, Long> {
	 List<caloirburing> findByUserId(User user);
	 List<caloirburing> findByUserAndConsumedDate(User user, LocalDate consumedDate);
		 List<caloirburing> findByConsumedDate(LocalDate consumedDate);
	  List<caloirburing> findByUserIdAndConsumedDate(Long userId, LocalDate consumedDate);
	  List<caloirburing> findByConsumedDateAndUserId(LocalDate consumedDate, Long userId);
}
