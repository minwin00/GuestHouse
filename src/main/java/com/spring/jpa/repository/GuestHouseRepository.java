package com.spring.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.entity.GuestHouse;
import com.spring.jpa.entity.User;

public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long>{
	
	// 1. 전체 게스트하우스 목록 반환
	List<GuestHouse> findAll();

	// 2. 전체 게스트하우스 중, 하나를 임의로 선정하여 반환
	@Query(value = "SELECT * FROM GuestHouse ORDER BY RAND() LIMIT 1", nativeQuery = true)
	GuestHouse findRandomGuestHouse();

	// 3. 특정 게스트하우스 반환 (이름으로 탐색)
	@Query("SELECT g FROM GuestHouse g WHERE g.name = :name")
	GuestHouse findByName(String name);
	
	// 4. 특정 지역의 게스트하우스 중, 하나를 임의로 선정하여 반환
	@Query(value = "SELECT * FROM GuestHouse WHERE location = :location ORDER BY RAND() LIMIT 1", nativeQuery = true)
	GuestHouse findRandomGuestHouseByLocation(String location);

	// 5. 특정 게스트하우스의 ID를 활용하여 해당 게스트하우스의 게임참여자 중, 상위 3명의 레코드 반환
	@Query("SELECT u,r FROM User u JOIN Ranking r ON u.userId = r.user.userId " +
	           "WHERE r.guestHouse.guestHouseId = :guestHouseId " +
	           "ORDER BY r.duration ASC " +
	           "LIMIT 3")
	 List<Object[]> findTop3UsersByGuestHouseId(Long guestHouseId);
	
	
	// 6. 특정 게스트하우스의 이름를 활용하여 해당 게스트하우스의 게임참여자 중, 상위 3명의 레코드 반환
	@Query("SELECT u,r FROM User u " +
	        "JOIN Ranking r ON u.userId = r.user.userId " +
	        "JOIN GuestHouse gh ON r.guestHouse.guestHouseId = gh.guestHouseId " +
	        "WHERE gh.name = :guestHouseName " +
	        "ORDER BY r.duration ASC " +
	        "LIMIT 3")
	 List<Object[]> findTop3UsersByGuestHouseName(String guestHouseName);
	 
	 // 7. 특정 게스트하우스 반환 (id로 검색)
	@Query("SELECT g FROM GuestHouse g WHERE g.guestHouseId = :id")
	GuestHouse findGuestHouseById(@Param("id")Long id);
		
}
