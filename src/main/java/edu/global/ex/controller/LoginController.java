package edu.global.ex.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.global.ex.service.UserService;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	   private PasswordEncoder encoder;
	  
	@GetMapping("/login")
	public String login() {
		log.info("login()..");
		return "login/login";
	}
	
	   @RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
	   public String loginInfo(Authentication authentication,Principal principal, Model model) {
	      
	      String user_id;
	      
	      //1.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 )      
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        user_id = auth.getName();
	        System.out.println("유저 아이디:" + user_id   );
	                      
	      //2.authentication 객체로 가져오는 방법(많은 )              
	      System.out.println("authentication 유저 아이디:" + authentication.getName()   );
	      System.out.println("authentication 권한들:" + authentication.getAuthorities()   );
	      
	      //3.Principal 객체로 가져오는 방법(가져올수 있는게 getName() 정도             
	      System.out.println("Principal 유저 아이디:" + principal.getName() );
	        
	        return "redirect:/";
	   }
	   
	   //restful 방식. get 방식으로 했으면 ? 달렸어야함
	   @GetMapping("/addUser/{id}/{pw}") // url을 파라미터화 시키는 것. @PathVariable을 통해서 파라미터화 시킨 것을 넘겨줌.
	   public String addUser(@PathVariable String id, @PathVariable String pw) throws Exception {
		   
		 System.out.println(id + ":" + pw);
		 
		 UserVO user = new UserVO();
	      user.setEnabled(1);
	      user.setUsername(id);
	      user.setPassword(encoder.encode(pw.toString().trim()));
	      
	      System.out.println(user);

	     // userService.addUser(user);
         // userService.addUser2(user);
	     // userService.addUser3(user);
	     // userService.addUser4(user);
	     //  userService.addUser5(user);
	       userService.addUser6(user);
		 
		 return "redirect:/";
	   }

}
