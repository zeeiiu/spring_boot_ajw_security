package edu.global.ex.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
   void testDataSource() {
      System.out.println(datasource);
      assertNotNull(datasource);
      
   }
   @Test
   void testConnetion() throws Exception {
      System.out.println("DS=" + datasource);
      
      try (Connection conn = datasource.getConnection()) {
         System.out.println("Cooooooooonn=" + conn);
         
         assertThat(conn).isInstanceOf(Connection.class);
         assertEquals(100, getLong(conn, "select 100 from dual"));
         //assertTrue(0 < getLong(conn, "select count(*) from User"));

      } catch (Exception e) {
         e.printStackTrace();
      }      
   }
   
   private long getLong(Connection conn, String sql) {
      long result = 0;
      try (Statement stmt = conn.createStatement()) {
         ResultSet rs = stmt.executeQuery(sql);
         if (rs.next()) {
            result = rs.getLong(1);
         }
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }

      
      
      

}
