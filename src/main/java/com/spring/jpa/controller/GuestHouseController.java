package com.spring.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.dto.GameStartRes;
import com.spring.jpa.dto.GuestHouseRes;
import com.spring.jpa.entity.GuestHouse;
import com.spring.jpa.service.GuestHouseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins ={"*"}, maxAge = 6000)
@RequiredArgsConstructor
@Tag(name = "GuestHouse Controller", description = "게스트 하우스 정보와 관련된 Controller")
public class GuestHouseController {
	
	final GuestHouseService guestHouseService;
	
	/*
	 * 게임이 시작되면, 랜덤하게 게하 이름을 선택. (해당 이름은 세션에 저장됨)
	 * 선택된 게하의 이름으로 셔플링하여 리스트를 리턴
	 */
	@GetMapping("/start")
	@Operation(summary = "단어 변형 생성", description = "게임 진행을 위해 변형된 단어의 목록을 생성하여 반환합니다.")
	public ResponseEntity<?> generateAnagram(HttpSession session){
		GuestHouseRes gh = guestHouseService.getRandomGuestHouse();
		
		String originalName = gh.getName();
		session.setAttribute("originalName", originalName);
		
		Long guestHouseId = gh.getId();
		List<String> list = guestHouseService.generateAnagrams(originalName);
		
		GameStartRes game = new GameStartRes(guestHouseId, originalName, list);
		return new ResponseEntity<>(game, HttpStatus.OK);
	}
	
	
	/*
	 * 게하의 id가 주어지면 게하 정보를 리턴
	 */
	@GetMapping("/end/{id}")
	@Operation(summary = "게스트 하우스 조회", description = "ID로 게스트 하우스의 정보를 반환합니다.")
	public ResponseEntity<?> getGuestHouseInfoById(@PathVariable Long id){
		GuestHouseRes gh = guestHouseService.findGuestHouseById(id);
		return new ResponseEntity<>(gh, HttpStatus.OK);
	}
	
}
