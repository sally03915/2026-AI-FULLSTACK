package com.the703.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

	//http://localhost:8080/tmpt
	//@RequestMapping("/tmpt")
	@GetMapping("/tmpt")
	public String tmpt() {  return "tmpt"; }   // prefix(/templates) + tmpt  +  suffix(.html)
	
	
	@GetMapping("/basic")
	public String basic( Model  model) { 
		model.addAttribute("msg"  , "hello");
		model.addAttribute("nums" ,  List.of(1,2,3,4,5));
		return "basic";
	}  
	
	//1. tmpt 복사해서 basic 만들기
	//2. http://localhost:8080/basic 했을때 basic.html 열리기   ( th:text )
	
}
