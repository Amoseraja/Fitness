package com.myfitness.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myfitness.Entity.User;
import com.myfitness.Entity.caloirintake;

public interface CalorieIntakeRepository extends JpaRepository<caloirintake, Long> {
	//List<caloirintake> findByUserIdAndConsumedDate(String userId, LocalDate consumedDate);
    List<caloirintake> findByUserId(User user);
	 List<caloirintake> findByUserAndConsumedDate(User user, LocalDate consumedDate);
	 List<caloirintake> findByConsumedDate(LocalDate consumedDate);
	  List<caloirintake> findByUserIdAndConsumedDate(Long userId, LocalDate consumedDate);
	  List<caloirintake> findByConsumedDateAndUserId(LocalDate consumedDate, Long userId);
//	  @Query("SELECT c FROM caloirintake c WHERE c.user.id = :userId AND c.consumedDate = :consumedDate")
//	    List<caloirintake> findByUserIdAndConsumedDate1(@Param("userId") Long userId, @Param("consumedDate") LocalDate consumedDate);
}
