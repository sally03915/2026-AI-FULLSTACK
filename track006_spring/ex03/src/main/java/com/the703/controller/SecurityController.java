package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security/*")
public class SecurityController {
	
	@RequestMapping("/all")
	public String all() {  return "security/all"; }
	
	
	@RequestMapping("/member")
	public String member() {  return "security/member"; }
	
}
