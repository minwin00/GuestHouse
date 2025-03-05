package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.entity.Ranking;
import com.spring.jpa.entity.Coupon;


public interface CouponRepository extends JpaRepository<Coupon, Long>{
	List<Coupon> findAllByUserUserId(Long userId);
    long countByUserUserId(Long userId);
}
