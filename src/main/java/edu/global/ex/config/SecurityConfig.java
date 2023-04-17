package edu.global.ex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration /* @Component + 의미(Configuration. 즉 설정할 수있는 파일) ,,
               IOC 컨테이너에 갖다 넣어라. IOC컨테이너에 객체들이 들어가고 IOC컨테이너가 관리하는 것이 기본 컨셉. */ 
@EnableWebSecurity /*스프링 시큐리티 필터가 스프링 필터체인에 등록됨. = 스프링 시큐리티를 작동 시키는 파일 이라는 걸 알려줌. 스프링한테*/
public class SecurityConfig extends WebSecurityConfigurerAdapter{ // 무조건 상속해야지 시큐리티를 작동 시키는 파일이 됨. 정해진 것. 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 우선 CSRF 설정을 해제한다.
		// 초기 개발시만 해주는게 좋다. 
		
		http.csrf().disable();
	   
		 http.authorizeRequests()
//	      .antMatchers("/user/**").hasAnyRole("USER") 
//	      .antMatchers("/admin/**").hasAnyRole("ADMIN")
	      .antMatchers("/**").hasAnyRole("ADMIN"); // 루트로 치고 들어오는 모든 폴도둘운 권한이  어드민인 것만 치고 들어와라. 이제 유저로 치고 가면 안될 것임. 
	      
	      http.formLogin(); //스프링 시큐리티에 있는 기본 로그인 폼을 사용하겠다.
	
	
	}
	
	  @Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	       
	      auth.inMemoryAuthentication() // 테스트 할 때 아래 두개와 같이 하지 실무에서는 하지않음.
	           .withUser("user").password("{noop}user").roles("USER").and()
	           .withUser("admin").password("{noop}admin").roles("ADMIN");
	   
	   }

	
	
	
	
	}

