package com.spring.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.dto.RankingReq;
import com.spring.jpa.service.RankingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@CrossOrigin(origins ={"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("ranking")
@Tag(name = "Ranking Controller", description = "게임 랭킹과 관련된 Controller")
public class RankingController {
    
    final RankingService rankingService;
    
    // 랭킹 생성
    @PostMapping("/addRanking")
    public ResponseEntity<?> addRanking(@RequestBody RankingReq ranking){
    	return new ResponseEntity<>( rankingService.addRanking(ranking) ,HttpStatus.ACCEPTED  );
    }
    

    //특정 게스트 하우스의 TOP3 랭킹 조회
    @GetMapping("/top3/{guestHouseId}")
    @Operation(summary = "게스트 하우스 별 TOP3 랭킹 조회", description = "게스트 하우스 ID로 해당 게스트 하우스의 게임 TOP3 랭킹을 조회합니다.")
    public ResponseEntity<?> getTop3Ranking(@PathVariable Long guestHouseId) throws Exception {
        return new ResponseEntity<>(rankingService.findTop3UsersByGuestHouseId(guestHouseId), HttpStatus.OK);
    }

    //특정 유저의 게임 기록 조희
    @GetMapping("/userRank/{userId}")
    @Operation(summary = "게임 기록 조회", description = "ID로 사용자의 게임 플레이 기록을 조회합니다.")
    public ResponseEntity<?> getUserRanking(@PathVariable Long userId) throws Exception {
        return new ResponseEntity<>(rankingService.findByUserId(userId), HttpStatus.OK);
    }


}