package com.spring.jpa.dto;

import java.time.Duration;

import com.spring.jpa.entity.Ranking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RankingRes {

	private long rankingId;
	private UserRes user;
	private GuestHouseRes guestHouse;
	private Long durationSeconds;
	private float discountRate;

	public RankingRes(Ranking ranking) {
		rankingId = ranking.getRankingId();
		user=new UserRes(ranking.getUser());
        guestHouse=new GuestHouseRes(ranking.getGuestHouse());
        durationSeconds= ranking.getDuration().getSeconds(); 
        discountRate=ranking.getDiscountRate();
	}
}
