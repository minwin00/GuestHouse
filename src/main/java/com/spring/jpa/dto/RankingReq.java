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
	
	
	private long rankingId;
	private long userId;
	private long guestHouseId;
	private Duration duration;
	private float discountRate;
	
	public Ranking toRanking(RankingReq rankingReq) {
		return Ranking.builder()
    		    .rankingId(rankingReq.getRankingId())
    		    .user(User.builder().userId(rankingReq.userId).build())
    		    .guestHouse(GuestHouse.builder().guestHouseId(rankingReq.guestHouseId).build())
    		    .duration(rankingReq.getDuration())
    		    .discountRate(rankingReq.getDiscountRate())
    		    
                .build();
	}
}
