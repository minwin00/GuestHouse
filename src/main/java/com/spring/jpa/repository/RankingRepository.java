package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.entity.Ranking;
import com.spring.jpa.entity.User;

public interface RankingRepository extends JpaRepository<Ranking, Long>{
	
	/*
		- 특정 User의 게임 기록 목록을 반환하는 함수 (부가기능4) 
		- Ranking 테이블 초기화하는 함수 (부가기능3)*/
	
	// 2. 특정 유저의 게임 기록 목록을 반환하는 함수
    // List<Ranking> findByUserId(Long userId);
    
    // 3. Ranking 테이블 초기화하는 함수
    @Modifying
    @Query("DELETE FROM Ranking")
    void deleteAllRankings();
    
    /* 
     4. 특정 게스트 하우스 상위 3명의 User 정보 가져오는 함수
     #Parameter --> Long guestHouseId
     #Output --> List<Object[]>
    */ 
//    @Query("SELECT u, r.duration, RANK() OVER (ORDER BY r.duration ASC)" +
//    		"FROM User u " +
//            "JOIN Ranking r ON u.userId = r.user.userId " +
//            "WHERE r.guestHouse.guestHouseId = :guestHouseId " +
//            "ORDER BY r.duration ASC " +
//            "LIMIT 3")
//     List<Object[]> findTop3UsersByGuestHouseId(Long guestHouseId);
    
}
