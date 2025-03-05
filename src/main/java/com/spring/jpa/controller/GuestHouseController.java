package com.spring.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.dto.GuestHouseRes;
import com.spring.jpa.entity.GuestHouse;
import com.spring.jpa.service.GuestHouseService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GuestHouseController {
	
	final GuestHouseService guestHouseService;
	
	/*
	 * 게임이 시작되면, 랜덤하게 게하 이름을 선택. (해당 이름은 세션에 저장됨)
	 * 선택된 게하의 이름으로 셔플링하여 리스트를 리턴
	 */
	@GetMapping("/start")
	public ResponseEntity<?> generateAnagram(HttpSession session){
		String originalName = guestHouseService.getRandomGuestHouse();
		session.setAttribute("originalName", originalName);
		List<String> list = guestHouseService.generateAnagrams(originalName);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/*
	 * 세션에 저장된 오리지널 이름과 유저의 선택지를 비교
	 */
	@PostMapping("/check")
	public ResponseEntity<?> checkAnswer(@RequestBody String userAnswer, HttpSession session) {
		String originalName = (String)session.getAttribute("originalName");
		boolean check = guestHouseService.checkAnswer(userAnswer, originalName);
		return new ResponseEntity<>(check, HttpStatus.OK);
	}
	
	/*
	 * 게하의 id가 주어지면 게하 정보를 리턴
	 */
	@GetMapping("/end/{id}")
	public ResponseEntity<?> getGuestHouseInfo(@PathVariable Long id){
		GuestHouseRes gh = guestHouseService.findGuestHouseById(id);
		return new ResponseEntity<>(gh, HttpStatus.OK);
	}
}
