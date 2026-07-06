package com.the703.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements  WebMvcConfigurer{
	@Value("${upload.path}")    private String uploadPath;     //  /upload/**
	@Value("${resource.path}")  private String resourcePath;   //  C:/upload
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler(uploadPath)
    	        .addResourceLocations("file:" + resourcePath + "/");
    }
}
