package edu.global.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.UserMapper;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 스프링으로 하여금 mybatis 인터페이스 인걸 알려줌
public class UserService {

	@Autowired
	private UserMapper userMapper;

	// 1.정상 동작 코드 => User를 insert를 넣은후 권한 까지 insert 해야 됨 => 2개가 정상적인 동작이 되어야 됨(트랜잭션 단위)
	// 2. 2개가 정상적인 동작이 되어야 됨 (트랜잭션 단위)
	// 에는 들가 있으나 select * from authorities 권한에 안들어 가있음
	public void addUser(UserVO user) {
		log.info("addUser()..");

		userMapper.insertUser(user); // User를 insert를 넣은후
		userMapper.insertAuthorities(user); // 권한 설정

	}
	
	
	
	public void addUser2 (UserVO user) {
		log.info("addUser()..");

		userMapper.insertUser(user); // User를 insert를 넣은후
		
		
		//일부러 에러냄
		user = null;
	
		userMapper.insertAuthorities(user); // 권한 설정
	}
	

	// 3. 아래처럼 @Transactional을 붙임 // 롤백이 되어 아무런 데이터가 들어가지 않음. 윗 소스는 @Transactional안붙인거
	@Transactional
	public void addUser3 (UserVO user) {
		log.info("addUser()..");
		
		userMapper.insertUser(user); // User를 insert를 넣은후
		
		
		//일부러 에러냄
		user = null;
		userMapper.insertAuthorities(user); // 권한 설정
		
	}
	
	   // 4.checked Exception을 강제로 시켜 봄 //롤백 되지 않음
	   @Transactional
	   public void addUser4(UserVO user) throws Exception {
	      log.info("addUser()..");

	      userMapper.insertUser(user); // User를 insert를 넣은후
	      userMapper.insertAuthorities(user);

	      // throw Checked Exception
	      throw new Exception("Exception (Checked Exception)"); // 테스트를 위해 강제로 에러냄
	   }
	   

	   // 5. unchecked Exception을 강제로 시켜 봄 //롤백 됨
	   @Transactional
	   public void addUser5(UserVO user) throws Exception {
		   log.info("addUser()..");
		   
		   userMapper.insertUser(user); // User를 insert를 넣은후
		   userMapper.insertAuthorities(user);
		   
		   // throw Checked Exception
		   throw new RuntimeException("RuntimeException (Unchecked Exception)"); // 테스트를 위해 강제로 에러냄
	   }
	

	   // 6. rollbackFor 옵션을 줌 //롤백 됨
	   @Transactional (rollbackFor = Exception.class) // 체크든 언체크든 롤백시키겠다. Exception은 최고 부모
	   public void addUser6(UserVO user) throws Exception {
		   log.info("addUser()..");
		   
		   userMapper.insertUser(user); // User를 insert를 넣은후
		   userMapper.insertAuthorities(user);
		   
		   // throw Checked Exception
		   throw new RuntimeException("RuntimeException (Unchecked Exception)"); // 테스트를 위해 강제로 에러냄
	   }
	   
	
	
	
}
