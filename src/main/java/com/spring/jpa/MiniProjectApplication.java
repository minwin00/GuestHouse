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
		
		//===============GUEST HOUSE 생성===============
		GuestHouse gh1 = new GuestHouse();
		gh1.setName("산들바람");
		gh1.setCapacity(10);
		gh1.setLocation("경기도");
		gh1.setPrice(100000);
		guestHouseRepository.save(gh1);
		
		GuestHouse gh2 = new GuestHouse();
		gh2.setName("파라다이스");
		gh2.setCapacity(15);
		gh2.setLocation("강원도");
		gh2.setPrice(150000);
		guestHouseRepository.save(gh2);
		
		GuestHouse gh3 = new GuestHouse();
		gh3.setName("꽃과동산");
		gh3.setCapacity(20);
		gh3.setLocation("경상도");
		gh3.setPrice(170000);
		guestHouseRepository.save(gh3);
		
		GuestHouse gh4 = new GuestHouse();
		gh4.setName("행복한 게스트하우스");
		gh4.setCapacity(20);
		gh4.setLocation("경기도");
		gh4.setPrice(120000);
		guestHouseRepository.save(gh4);
		
		GuestHouse gh5 = new GuestHouse();
		gh5.setName("최고의 게스트하우스");
		gh5.setCapacity(10);
		gh5.setLocation("경기도");
		gh5.setPrice(150000);
		guestHouseRepository.save(gh5);
		
		GuestHouse gh6 = new GuestHouse();
		gh6.setName("아름다운 게스트하우스");
		gh6.setCapacity(30);
		gh6.setLocation("강원도");
		gh6.setPrice(250000);
		guestHouseRepository.save(gh6);
		
		GuestHouse gh7 = new GuestHouse();
		gh7.setName("베스트 게스트하우스");
		gh7.setCapacity(30);
		gh7.setLocation("전라도");
		gh7.setPrice(200000);
		guestHouseRepository.save(gh7);
		
		GuestHouse gh8 = new GuestHouse();
		gh8.setName("서진이네 게스트하우스");
		gh8.setCapacity(20);
		gh8.setLocation("전라북도");
		gh8.setPrice(280000);
		guestHouseRepository.save(gh8);
		
		GuestHouse gh9 = new GuestHouse();
		gh9.setName("딘's 게스트하우스");
		gh9.setCapacity(20);
		gh9.setLocation("경기도");
		gh9.setPrice(150000);
		guestHouseRepository.save(gh9);
		
		GuestHouse gh10 = new GuestHouse();
		gh10.setName("헤일리의 게스트하우스");
		gh10.setCapacity(30);
		gh10.setLocation("경기도");
		gh10.setPrice(250000);
		guestHouseRepository.save(gh10);
		
		GuestHouse gh11 = new GuestHouse();
		gh11.setName("유진이네 게스트하우스");
		gh11.setCapacity(15);
		gh11.setLocation("경기도");
		gh11.setPrice(200000);
		guestHouseRepository.save(gh11);
		
		GuestHouse gh12 = new GuestHouse();
		gh12.setName("연승 게스트하우스");
		gh12.setCapacity(30);
		gh12.setLocation("경기도");
		gh12.setPrice(250000);
		guestHouseRepository.save(gh12);
	}

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectApplication.class, args);
	}

}
