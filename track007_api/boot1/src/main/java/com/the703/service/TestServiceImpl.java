package com.the703.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the703.dao.TestDao;

@Service
public class TestServiceImpl implements TestService{
	@Autowired  TestDao dao; 
	@Override public String readTime() { return dao.readTime(); }	
}
