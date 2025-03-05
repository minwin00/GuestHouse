package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.entity.Coupon;
import com.spring.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	/* User 테이블에서 중복되는 이름의 존재 여부 확인하는 함수 ( 시나리오1 )
	 * */
	
	//이름으로 유저 찾기
	//@Query(value = "SELECT * FROM User WHERE name= :name2")
	//User findUserByName(@Param("userName")String name2);
	
	@Query(value="SELECT a FROM User a where a.userName= :userName")
	User findUserByName(@Param("userName") String userName);
	
	@Query(value="SELECT COUNT(userName) FROM User a where a.userName= :userName")
	Long checkDuplicateName(@Param("userName")String userName);
	
	@Query("SELECT COUNT(c) FROM Coupon c WHERE c.user.userName = :userName")
    Integer countCouponsByUserName(@Param("userName") String userName);

	@Query("SELECT c FROM Coupon c WHERE c.user.userName = :userName")
    List<Coupon> findCouponsByUserName(@Param("userName") String userName);
	
}
