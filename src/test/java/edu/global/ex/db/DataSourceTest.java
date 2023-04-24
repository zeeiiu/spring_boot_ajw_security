package edu.global.ex.db;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest //모든 빈들을 스캔하고 애플리케이션 컨텍스트를 생성하여 테스트를 실행한다.
class DataSourceTest {

   @Autowired
   private DataSource datasource;
   
   @Test
   void dataSourcetest() {
      System.out.println(datasource);
      assertNotNull(datasource);
   }

}
