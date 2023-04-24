package edu.global.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.mapper.UserMapper;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 스프링으로 하여금 mybatis 인터페이스 인걸 알려줌
public class UserService { 
	
	
	@Autowired
	private UserMapper userMapper;
	
	public int addUser(UserVO user) {
		log.info("addUser()..");
		return userMapper.insertUser(user);
	}
	
}

