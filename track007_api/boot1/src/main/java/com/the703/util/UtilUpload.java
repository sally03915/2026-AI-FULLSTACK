package com.the703.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UtilUpload  { 
	@Value("${resource.path}") private String resourcePath; //    C:/upload
    // org.springframework.beans.factory.annotation.Value

	public String fileUpload(  MultipartFile file) throws IOException {
		//1. 파일이름중복안되게
		UUID uid    = UUID.randomUUID();
		String save = uid.toString() + "_" + file.getOriginalFilename() ;
		//2. 파일업로드
		File target = new File(resourcePath, save);
		FileCopyUtils.copy(file.getBytes(), target);  //실제파일처리
		return save;
	}
}
