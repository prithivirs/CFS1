package com.hotfoot.rapid.ai.security.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.security.pojo.AuthenticationRequest;
import com.hotfoot.rapid.ai.security.service.SecretTokenProviderService;
import com.hotfoot.rapid.ai.security.service.TokenCreationService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private SecretTokenProviderService secretTokenProvider;
	
	@Autowired
	private TokenCreationService tokenCreator;

	
	@GetMapping(value="/rest/generate/secretkey")
	private String generateSecretKey(@RequestParam("client") String client) {
		return secretTokenProvider.generateSecretKey(client);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="/rest/create/token")
	private AuthenticationRequest createToken(@RequestBody AuthenticationRequest authenticationRequest,
			HttpServletResponse response) {
		return tokenCreator.createToken(authenticationRequest,response);
	}
	
}
