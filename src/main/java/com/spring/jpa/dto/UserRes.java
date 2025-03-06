package com.spring.jpa.dto;

import com.spring.jpa.entity.User;

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
public class UserRes {
//	회원정보 일치확인 : name, password
	private String name;
	private String passWord;
	private Long id;
	
	public UserRes(User user) {
		name = user.getUserName();
		passWord = user.getPassWord();	
		id = user.getUserId();
	}
}
