package edu.global.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.vo.UserVO;

@Mapper // 스프링으로 하여금 mybatis 인터페이스 인걸 알려줌
public interface UserMapper { 
	
	
	 public UserVO getUser(String username);   
	   
	   @Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
	   public int insertUser(UserVO userVO);

	   @Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
	   public void insertAuthorities(UserVO UserVO);
	   
	   @Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_ADMIN')")
	   public void insertAdminAuthorities(UserVO UserVO);
}

