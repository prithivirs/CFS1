package com.hotfoot.rapid.ai.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.token.datamodel.TokenCache;
import com.hotfoot.rapid.ai.token.repository.TokenCacheRepository;

@Component
public class LogoutService {

	@Autowired
	private TokenCacheRepository tokenCacheRepo;

	@Autowired
	private TokenCreationService tokenService;

	public boolean logout(HttpServletRequest request, HttpServletResponse response) {
		String token = tokenService.getToken(request);
		if (token != null) {
			TokenCache findByToken = tokenCacheRepo.findByToken(token);
			if (findByToken != null) {
				tokenCacheRepo.delete(findByToken);
			}
			tokenService.clearCookies(request, response);
			return true;
		}
		return false;
	}

}
