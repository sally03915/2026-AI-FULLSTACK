package com.the703.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;

@Controller
public class UserController {

	@Autowired  UserService service;
	
	@RequestMapping( "/" )
	public String index() {  return "redirect:/users/login"; }

	@ResponseBody
	@RequestMapping(value="/doubleNickname" , method=RequestMethod.GET)
	public Map<String, Object> doubleNickname(  @RequestParam("nickname")  String nickname ){
		Map<String, Object> result = new HashMap<>();
		
		//db에서 이메일 존재여부 확인
		UserDto find = service.findByNickname(nickname);
		
		if(find != null) { result.put(  "exists"  , true);  }
		else             { result.put(  "exists"  , false); }
		return result;
	}	
	
	@ResponseBody
	@RequestMapping(value="/doubleEmail" , method=RequestMethod.GET)
	public Map<String, Object> doubleEmail(  @RequestParam("email")  String email ){
		Map<String, Object> result = new HashMap<>();
		
		//db에서 이메일 존재여부 확인
		String find = service.findByEmail(email);
		
		if(find != null) { result.put(  "exists"  , true);  }
		else             { result.put(  "exists"  , false); }
		return result;
	}
	///////////////////////////////////////
	@RequestMapping( value="/users/join" , method=RequestMethod.GET  )
	public String join() {  return "users/join"; }
	
	@PreAuthorize("isAnonymous()")  
	@RequestMapping(value="/users/join" , method=RequestMethod.POST)   
	public String join_post(UserDto dto) {   
		service.insert(dto); 
		return "redirect:/users/login"; 
	}
	 
	@RequestMapping( value="/users/login" , method=RequestMethod.GET  )
	public String login() {  return "users/login"; }
	 
	@RequestMapping("/users/mypage") public String mypage( Principal  principal , Model model  ) {  
		model.addAttribute("dto" , service.findByEmailUserInfo(  principal.getName() ));
		return "users/mypage"; 
	}
	
}
