package com.the703.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{   

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										 HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	 
		List<String>  roles = new ArrayList<>(); 
		authentication.getAuthorities().forEach(auth->{ roles.add(auth.getAuthority()); });
 
		// if(roles.contains("ROLE_ADMIN"))
		// { response.sendRedirect( request.getContextPath() + "/security/admin"   );}
		
		response.sendRedirect( request.getContextPath() + "/users/mypage"   );
		
	}

}












