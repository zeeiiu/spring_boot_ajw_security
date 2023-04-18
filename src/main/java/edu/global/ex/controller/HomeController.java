package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	 @GetMapping("/user/userHome")
	   public void userHome() {  // 리턴값이 void. 스프링에서는 void란, 
	      log.info("userHome ...");
	   }

/*	 @GetMapping("/user/userHome")
	 public String userHome2() {  
		 log.info("userHome ...");
		 return "/user/userHome"; // 위에서 void쓰면 이렇게 리턴된 것과 같음. 개발자들이 리턴값 쓰기 귀찮아서 위에처럼 void 씀 
	 } */
	 
	 
	   
	   @GetMapping("/admin/adminHome")
	   public void adminHome() {
	      log.info("adminHome ...");
	   }

}