package com.hotfoot.rapid.ai.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotfoot.rapid.ai.security.service.LogoutService;
import com.hotfoot.rapid.ai.security.service.TokenCreationService;

public class TokenAuthenticationFilter implements Filter {

	@Autowired
	private TokenCreationService tokenService;

	@Autowired
	private LogoutService logoutService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String currentToken = tokenService.getToken((HttpServletRequest) request);
		if (currentToken == null) {
			logoutService.logout((HttpServletRequest) request, (HttpServletResponse) response);
		}

	}

}
