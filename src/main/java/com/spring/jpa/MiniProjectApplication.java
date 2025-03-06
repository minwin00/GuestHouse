package com.spring.jpa;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.entity.GuestHouse;
import com.spring.jpa.entity.Ranking;
import com.spring.jpa.entity.User;
import com.spring.jpa.dto.UserLoginReq;
import com.spring.jpa.dto.UserReq;
import com.spring.jpa.entity.Coupon;
import com.spring.jpa.repository.GuestHouseRepository;
import com.spring.jpa.repository.RankingRepository;
import com.spring.jpa.repository.UserRepository;
import com.spring.jpa.service.UserService;
import com.spring.jpa.service.CouponService;
import com.spring.jpa.repository.CouponRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class MiniProjectApplication implements CommandLineRunner{
	
	@Autowired
	private GuestHouseRepository guestHouseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RankingRepository rankingRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private UserService userService;
	private CouponService couponService;
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		// ==== 쿠폰 테스팅 코드 끝 =====
		
		// 쿠폰 서비스 테스팅
//		User u1 = userRepository.findUserByName("TestUser");
//		GuestHouse g1 = guestHouseRepository.findByName("TestGuestHouse");
//	    Coupon c1 = new Coupon();
//	    c1.setUser(u1);
//	    c1.setGuesthouse(g1);
//	    c1.setDiscountRate(0.1f);
//	    couponRepository.save(c1);
//	    
//	    List<Coupon> result1 = couponRepository.findAllByUserUserId(u1.getUserId());
//	    System.out.println("TestUser에게 쿠폰은" + result1.size() + "개");
//	    Long result2 = couponRepository.countByUserUserId(u1.getUserId());
//	    System.out.println("TestUser에게 쿠폰은" + result2 + "개");
		
		// ==== 쿠폰 테스팅 코드 끝 ===== 
	//	System.out.println("findUserBy Name test" + userRepository.findUserByName("AAA") );

		
		//UserService 테스트하기.
		
		//addUser 테스트하기.
		
		//userReq만들기 
		UserReq userReq = new UserReq("lyj5341@naver.com", "010-xxx-xxx", "F", "12345678");
		userService.addUser(userReq);
//		userService.findUser("yujin");
//		userService.findUser("sohee");
		
		//Login 테스트하기
//		UserLoginReq userLoginReq = new UserLoginReq("yujin", "12345");
//		userService.logInUser(userLoginReq);
	}

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

}
