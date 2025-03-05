package com.spring.jpa.dto;

import com.spring.jpa.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.spring.jpa.entity.Coupon;
import com.spring.jpa.entity.GuestHouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponRes {
	
    private Long couponId;
    private Long userId;
    private Long guesthouseId;
    private float discountRate;
    
    public CouponRes(Coupon coupon) {
        couponId = coupon.getCouponId();
        userId = coupon.getUser().getUserId();
        guesthouseId = coupon.getGuesthouse().getGuestHouseId();
        discountRate = coupon.getDiscountRate();
    }
}