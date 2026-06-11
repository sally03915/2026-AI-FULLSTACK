package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping( value="/users/join" , method=RequestMethod.GET  )
	public String join() {  return "users/join"; }
	
	@RequestMapping( value="/users/login" , method=RequestMethod.GET  )
	public String login() {  return "users/login"; }
	
	@RequestMapping( value="/users/mypage" , method=RequestMethod.GET  )
	public String mypage() {  return "users/mypage"; }
	
}
