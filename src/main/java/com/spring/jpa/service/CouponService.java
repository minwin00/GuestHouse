package com.spring.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.jpa.dto.CouponRes;
import com.spring.jpa.entity.Coupon;
import com.spring.jpa.repository.CouponRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponService {
	
	final CouponRepository couponRepository;

    // UserId를 인자로 받아서, 그 유저가 가지고 있는 모든 쿠폰 목록을 List<CouponRes>로 반환 
    public List<CouponRes> getCouponsByUserId(Long userId) {
        List<Coupon> coupons = couponRepository.findAllByUserUserId(userId);
        return coupons.stream()
                .map(CouponRes::new)
                .collect(Collectors.toList());
    }

    // UserId를 인자로 받아서, 그 유저가 가지고 있는 모든 쿠폰의 갯수를 반환
    public long getCouponCountByUserId(Long userId) {
        return couponRepository.countByUserUserId(userId);
    }
	
}
