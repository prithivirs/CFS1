package com.hotfoot.rapid.ai.token;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.token.pojo.AuthenticationRequest;

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
	
	@PostMapping(value="/rest/create/token")
	private boolean createToken(@RequestBody AuthenticationRequest authenticationRequest,@RequestHeader("token") String secretKey,
			HttpServletResponse response) {
		return tokenCreator.createToken(authenticationRequest,response);
	}
	
}
