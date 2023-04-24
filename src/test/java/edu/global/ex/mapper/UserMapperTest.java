package edu.global.ex.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest // 모든 빈들을 스캔()하고 애플리케이션 컨텍스트를 생성하여 테스트를 실행한다.
class UserMapperTest {

   @Autowired
   private UserMapper userMapper;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   
   @Disabled // 이 테스트는 무시해라.
   @Test
   void testInserUser() {
      
      UserVO user = new UserVO();
      user.setUsername("kim5");
      user.setPassword(passwordEncoder.encode("1234"));
      user.setEnabled(1);

      userMapper.insertUser(user);
   }
   
   
   @Test
   void testInserAdmin() {
      
      UserVO user = new UserVO();
      user.setUsername("admin5");
      user.setPassword(passwordEncoder.encode("1234"));
      user.setEnabled(1);

      userMapper.insertUser(user);
      userMapper.insertAdminAuthorities(user);
   }
 

}