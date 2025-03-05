package com.spring.jpa.service;

import org.springframework.stereotype.Service;

import com.spring.jpa.dto.UserLoginReq;
import com.spring.jpa.dto.UserReq;
import com.spring.jpa.dto.UserRes;
import com.spring.jpa.entity.User;
import com.spring.jpa.exception.UserException;
import com.spring.jpa.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    final UserRepository userRepository;

    // 1. 유저 추가해주기(회원가입) (addUser)
    @Transactional
    public User addUser(UserReq userReq) {
        try {
            System.out.println("UserReq==>" + userReq);
            User user = userReq.toUser(userReq);

            if (userRepository.checkDuplicateName(user.getUserName()) >= 1)
                throw new UserException("사용할 수 없는 닉네임입니다");

            if (user.getPassWord().equals(""))
                throw new UserException("비밀번호를 입력하시오");

            System.out.println("toUser==>" + user);
            return userRepository.save(user);
        } catch (UserException e) {
            System.out.println("예외 발생 (회원가입 실패): " + e.getMessage());
            return null;  // 예외 발생 시 null 반환
        }
    }

    // 2. 이름으로 유저 찾기 (findUser)
    public UserRes findUser(String name) { 
        try {
            User user = userRepository.findUserByName(name);

            if (user == null)
                throw new UserException("해당 이름의 사용자가 없습니다");

            System.out.println(user.toString());
            return new UserRes(user);
        } catch (UserException e) {
            System.out.println("예외 발생 (유저 찾기 실패): " + e.getMessage());
            return null;  // 예외 발생 시 null 반환
        }
    }

    // 3. 유저 Login (logInUser)
    public UserRes logInUser(UserLoginReq userLoginReq) {
        try {
            User user = userRepository.findUserByName(userLoginReq.getName());

            if (user == null)
                throw new UserException("해당 이름의 사용자가 없습니다");

            if (!user.getPassWord().equals(userLoginReq.getPassWord()))
                throw new UserException("비밀번호가 일치하지 않습니다");

            System.out.println(user.toString() + " 로그인 성공");
            return new UserRes(user);
        } catch (UserException e) {
            System.out.println("예외 발생 (로그인 실패): " + e.getMessage());
            return null;  // 예외 발생 시 null 반환
        }
    }
}
