package com.spring.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.dto.CouponReq;
import com.spring.jpa.service.CouponService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
public class CouponController {
	
	final CouponService couponService;
	
	// UserId를 인자로 받아서, 그 유저가 가지고 있는 모든 쿠폰 목록을 List<CouponRes>로 반환
    @GetMapping("/coupons/getCouponsByUserId/{userId}")
    public ResponseEntity<?> getCouponsByUserId(@PathVariable Long userId) throws Exception{
    	return new ResponseEntity<>(couponService.getCouponsByUserId(userId),HttpStatus.OK);
    }
    
	// UserId를 인자로 받아서, 그 유저가 가지고 있는 모든 쿠폰의 갯수를 반환
    @GetMapping("/coupons/getCouponCountByUserId/{userId}")
    public ResponseEntity<?> getCouponCountByUserId(@PathVariable Long userId) throws Exception{
    	return new ResponseEntity<>(couponService.getCouponCountByUserId(userId),HttpStatus.OK);
    }


	
	// 쿠폰 새로 생성 CouponReq
//	@PostMapping("/coupons")
//	public ResponseEntity<?> save(@RequestBody CouponReq coupon){
//		return new ResponseEntity<>( couponService.addCoupon(coupon) ,HttpStatus.ACCEPTED  );
//	}
	
	// 쿠폰 수정
//	@PutMapping("/coupons/{id}")
//	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody CouponReq coupon)throws Exception{
//		return new ResponseEntity<>( couponService.updateCoupon(id, coupon) , HttpStatus.ACCEPTED );
//	}
    
	// 쿠폰 삭제        
//	@DeleteMapping("/coupons/{id}")
//	public ResponseEntity<?> delete(@PathVariable Long id)throws Exception{    
//		return new ResponseEntity<>( couponService.deleteCoupon(id) ,  HttpStatus.ACCEPTED );
//	}
    
}

