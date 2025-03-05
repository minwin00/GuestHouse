package com.spring.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name", unique=true)
	private String userName;
//	
//	@Column(name="game_count", nullable=true)
//	private Integer gameCount;
//	
//	@Column(name="num_coupon", nullable=true)
//	private Integer numCoupon;
	
	@Column(name="phone_num", nullable=true)
	private String phoneNum;
	
	@Column(nullable=true)
	private String sex;
	
	@Column(nullable=true)
	private String passWord;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phoneNum=" + phoneNum + ", sex=" + sex
				+ ", passWord=" + passWord + "]";
	}

	

	
	
}
