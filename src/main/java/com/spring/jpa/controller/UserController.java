package com.spring.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.dto.UserLoginReq;
import com.spring.jpa.dto.UserReq;
import com.spring.jpa.entity.User;
import com.spring.jpa.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"*"}, maxAge=6000)
@RestController
@RequiredArgsConstructor
public class UserController {
	
	final UserService userService;
	
	//회원가입 페이지
	@PostMapping("/users")
	public String signUp(@RequestBody UserReq userReq) throws Exception {
		//왜 custom에서는 req가 아닌 custom으로 했지? entity로?
		userService.addUser(userReq);
		return userReq.toString()+ " 회원가입 OK :) ";
	}
	
	//로그인 페이지
	@PostMapping("/users/login")
	public ResponseEntity<?> signIn(@RequestBody UserLoginReq userLoginReq) throws Exception{
		//userService.logInUser(userLoginReq);
		return new ResponseEntity<>(userService.logInUser(userLoginReq), HttpStatus.OK);
	}
	
	//이름으로 유저 찾기
	@GetMapping("/users/{name}")
	public ResponseEntity<?> getUser(@PathVariable String name) throws Exception{
		return new ResponseEntity<>(userService.findUser(name), HttpStatus.OK);
	}
}
