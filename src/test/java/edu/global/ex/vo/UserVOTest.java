package edu.global.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserVOTest {

   @Test
   void userVOtest() {
      UserVO vo = new UserVO();
      log.info("객체 생성" + vo);
   
      
      vo.setUsername("홍길동");
      vo.setPassword("1234");
      
      System.out.println(vo);
      
      assertNotNull(vo);
      assertEquals(vo.getUsername(), "홍길동");
   }

}
