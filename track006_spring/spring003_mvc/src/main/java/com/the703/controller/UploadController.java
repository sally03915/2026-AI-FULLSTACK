package com.the703.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	//1. 업로드할 폼
	@RequestMapping(value="/upload" , method = RequestMethod.GET)
	public String upload_get() {  return  "basic/uploadForm";}
	
	//2. 업로드 기능
	@RequestMapping(value="/upload" , method = RequestMethod.POST)
	public String upload_post( @RequestParam("name") String name,
							   @RequestParam("file") MultipartFile file,
							   Model model ) throws IllegalStateException, IOException {  
		///// 업로드 올리는 기능  - import java.io.File;
		if(!file.isEmpty()) {
			String uploadPath = "C:/file/";
			File   dest       = new File(  uploadPath + file.getOriginalFilename() );
			file.transferTo(dest);   // 올리기
			
			System.out.println("업로드유저 : " + name + "/" + "- 업로드성공>" + dest.getAbsolutePath());
			model.addAttribute("file"    , file.getOriginalFilename()); 
			model.addAttribute("name"    , name);
		}
		return  "basic/uploadResult";
	}  
}
