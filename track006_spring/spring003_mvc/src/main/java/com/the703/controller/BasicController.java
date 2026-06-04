package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//	<mvc:annotation-driven />   @Controller   , @RequestMapping("/basic.do")
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BasicController {
	
	
//	<property name="prefix"   value="/view/"/>
//	<property name="suffix"   value=".jsp"/>
	@RequestMapping("/basic.do")
	public String basic(Model model) {
		//## model
		model.addAttribute("result" , "Hello");
		return "basic";     //    /view/    +   basic    +    .jsp
	} 
}
