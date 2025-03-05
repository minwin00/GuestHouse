package com.spring.jpa.dto;

import com.spring.jpa.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

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
public class GameStartRes {
	
    private Long guestHouseId;
    private String guestHouseName;
    private List<String> list;
    
//    public GameStartRes(Long guestHouseId, List<String> list) {
//        this.guestHouseId = guestHouseId;
//        this.list = list;
//    }
}