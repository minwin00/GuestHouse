package com.spring.jpa.dto;

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
public class UserReq {

	//  i. Request: name, phone number, sex, password : 새로운 유저 생성하기 위함
	private String name;
	private String phoneNum;
	private String sex;
	private String passWord;
	
	public User toUser(UserReq userReq) {
		return User.builder()
				.userName(userReq.name)
				.phoneNum(userReq.phoneNum)
				.sex(userReq.sex)
				.passWord(userReq.passWord)
				.build();
	}

}
