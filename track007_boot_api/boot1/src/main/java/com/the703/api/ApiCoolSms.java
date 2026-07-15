package com.the703.api;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Component
public class ApiCoolSms {

	@Value("${coolsms.apikey}")
	String api_key;
	@Value("${coolsms.apisecret}")
	String api_secret;
	
	public String phoneNumber(String to) throws CoolsmsException { 
		//1. random 숫자 메시지만들기
		Random random = new Random();
		String result = String.format("%06d", random.nextInt(1000000));  //000123
		//2. 메지시보내기
		// net.nurigo.java_sdk.api.Message;
		Message message = new Message(api_key , api_secret);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to"  , to);
		params.put("from", to);  //발신전화 - 02,031,,,  회사번호
		params.put("type", "SMS");  
		params.put("text", "[THEJOA] 인증번호 : ["+result+"] 타인 유출로 인한 피해 주의");  
		message.send(params);
		return result;
	}
}
