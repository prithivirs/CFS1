package com.hotfoot.rapid.ai.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.security.service.LogoutService;

@RestController
public class LogoutController {
	
	@Autowired
	private LogoutService logoutService;
	
	@GetMapping(path = "/rest/user/logout")
	public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
		return ResponseEntity.ok(logoutService.logout(request,response));
	}


}
