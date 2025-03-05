package com.spring.jpa.service;

import org.springframework.stereotype.Service;

import com.spring.jpa.dto.UserLoginReq;
import com.spring.jpa.dto.UserReq;
import com.spring.jpa.dto.UserRes;
import com.spring.jpa.entity.User;
import com.spring.jpa.exception.DMLException;
import com.spring.jpa.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
//(왜냠 유저 추가해야함 && 로그인 && 회원가입)
	final UserRepository userRepository;
	
	//1. 유저 추가해주기(회원가입) (addUser)
	// 예외처리하기 
	// 1) name 중복, 2) Password 없음
	@Transactional
	public User addUser(UserReq userReq) throws Exception{
		System.out.println("UserReq==>"+userReq);
		User user = userReq.toUser(userReq);
		if(userRepository.checkDuplicateName(user.getUserName()) >= 1)
			throw new Exception("사용할 수 없는 닉네임입니다");
		if(user.getPassWord().equals(""))
			throw new Exception("비밀번호를 입력하시오");
		System.out.println("toUser==>"+user);
		return userRepository.save(user);
	}
	
	//2. 이름으로 유저 찾기 (findUser)
	public UserRes findUser(String name) throws Exception{
		User user = userRepository.findUserByName(name);
		
		if(user==null)
			throw new Exception("해당 이름의 사용자가 없습니다");
		System.out.println(user.toString());
		return new UserRes(user);
	}
	
	//3. 유저 Login
	public UserRes logInUser(UserLoginReq userLoginReq) throws Exception{
		User user = userRepository.findUserByName(userLoginReq.getName());
		if(user == null)
			throw new Exception("해당 이름의 사용자가 없습니다");
		if(!user.getPassWord().equals(userLoginReq.getPassWord()))
			throw new Exception("비밀번호가 일치하지 않습니다");
		System.out.println(user.toString() + "로그인 성공");
		return new UserRes(user);
	}
	
	
}
