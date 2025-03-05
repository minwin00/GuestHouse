package com.spring.jpa.entity;

import java.time.Duration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ranking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Ranking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ranking_id")
    private long rankingId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guesthouse_id")
    private GuestHouse guestHouse;
    
    @Column(name = "duration")
    private Duration duration;
    
    @Column(name = "discount_rate")
    private float discountRate;

	@Override
	public String toString() {
		return "Ranking [rankingId=" + rankingId + ", userId=" + user.toString() + ", guestHouseId=" + guestHouse.toString() + ", duration="
				+ duration + ", discountRate=" + discountRate + "]";
	}
}
