package edu.global.ex.mapper;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

   @Autowired
   private UserMapper userMapper;
   
//   @Test
//   void testInserUser() {
      
//      @Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
//      public int insertUser(UserVO userVO);
//
//      @Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
//      public void insertAuthorities(UserVO UserVO);
      
//      UserVO user = new UserVO();
//      user.setUsername("kim2");
//      user.setPassword(new BCryptPasswordEncoder().encode("kim2"));
//      user.setEnabled(1);
//            
//      userMapper.insertUser(user);
//      userMapper.insertAuthorities(user);
//      
//   }
//   
//   @Test
//   void testInserAdminUser() {
//	   
//	   UserVO user = new UserVO();
//	   user.setUsername("admin3");
//	   user.setPassword(new BCryptPasswordEncoder().encode("admin3"));
//	   user.setEnabled(1);
//	   
//	   userMapper.insertUser(user);
//	   userMapper.insertAdminAuthorities(user);
//   }
//  
   
   
   
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   @Autowired
   private UserVO userVO;
   
   @Test
   void testPassWordEncoder() {
      
      String plainPW = "1234";
      String encodedPW = passwordEncoder.encode(plainPW);
      
      System.out.println(encodedPW);
      
      userVO.setPassword(plainPW + ":" + encodedPW);
      
      System.out.println(passwordEncoder.matches(plainPW, encodedPW));
      System.out.println(userVO);

	   
	   // ==========================
	   
	   //assertNotEquals(plainPW, encodedPW);  //  assertNotEquals은 JUnit 에서 제공하는 함수
	  // assertEquals(plainPW, encodedPW);
	   
	   
       

   }

}