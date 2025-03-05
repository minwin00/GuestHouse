package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.entity.Coupon;
import com.spring.jpa.entity.Ranking;
import com.spring.jpa.entity.User;

public interface RankingRepository extends JpaRepository<Ranking, Long>{
	
	/*
		- 특정 User의 게임 기록 목록을 반환하는 함수 (부가기능4) 
		- Ranking 테이블 초기화하는 함수 (부가기능3)*/
	
	// 2. 특정 유저의 게임 기록 목록을 반환하는 함수
    List<Ranking> findByUser_UserId(Long user_id);
    
    // 3. Ranking 테이블 초기화하는 함수
    @Modifying
    @Query("DELETE FROM Ranking")
    void deleteAllRankings();
   
    
    /* 
    4. 특정 게스트 하우스 상위 3개 컬럼의 Ranking 정보 가져오는 함수
    #Parameter --> Long guestHouseId
    #Output --> List<Ranking>
   */ 
   @Query(value = """
               SELECT r.* FROM (
                   SELECT r.*, RANK() OVER (ORDER BY r.duration ASC) AS rankingOrder
                   FROM ranking r
                   WHERE r.guesthouse_id = :guestHouseId
                   ORDER BY r.duration ASC
               ) r
               WHERE r.rankingOrder <= 3
               """, nativeQuery = true)
    List<Ranking> findTop3UsersByGuestHouseId(Long guestHouseId);

    
}
