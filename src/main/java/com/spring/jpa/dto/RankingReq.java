package com.spring.jpa.dto;

import java.time.Duration;

import com.spring.jpa.entity.GuestHouse;
import com.spring.jpa.entity.Ranking;
import com.spring.jpa.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RankingReq {
	
	private long userId;
	private long guestHouseId;
	private long durationSeconds;	
	private float discountRate;
	
	public Ranking toRanking(RankingReq rankingReq) {
		return Ranking.builder()
    		    .user(User.builder().userId(rankingReq.userId).build())
    		    .guestHouse(GuestHouse.builder().guestHouseId(rankingReq.guestHouseId).build())
    		    .duration(Duration.ofSeconds(this.durationSeconds))  // 초를 Duration으로 변환
    		    .discountRate(rankingReq.getDiscountRate())
                .build();
	}
}
