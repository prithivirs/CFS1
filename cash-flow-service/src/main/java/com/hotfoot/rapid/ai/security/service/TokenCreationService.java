package com.hotfoot.rapid.ai.security.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.security.datamodel.TokenCache;
import com.hotfoot.rapid.ai.security.datamodel.Vault;
import com.hotfoot.rapid.ai.security.pojo.AuthenticationRequest;
import com.hotfoot.rapid.ai.security.repository.TokenCacheRepository;
import com.hotfoot.rapid.ai.security.repository.VaultRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenCreationService {

	private final String TOKEN = "TOKEN_HEADER";

	@Autowired
	private VaultRepository vaultRepo;

	@Autowired
	private TokenCacheRepository tokenCacheRepository;

	public boolean createToken(AuthenticationRequest authenticationRequest, HttpServletResponse response) {
		String loanId = authenticationRequest.getRequest().getLoanId();
		Vault developer = vaultRepo.findByVendorName(authenticationRequest.getClient());
		if (developer == null || developer.getSecretKey() == null) {
			return false;
		}
		byte[] decodedBytes = decodeFromBase64(authenticationRequest.getSecretKey());
		String originalEncodedString = new String(decodedBytes, StandardCharsets.UTF_8);
		String secretKey = developer.getSecretKey();
		// Verify if the token matches the original token
		if (secretKey.equals(originalEncodedString)) {
			Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
			String authToken = createJwt(key, loanId);
			TokenCache existingCache = tokenCacheRepository.findByLoanId(loanId);
			if (existingCache == null) {
				existingCache = new TokenCache();
				existingCache.setLoanId(loanId);
				existingCache.setToken(authToken);
				existingCache.setCreatedDate(new Date());
				tokenCacheRepository.save(existingCache);
			}else {
				authToken = existingCache.getToken();
			}
			Cookie cookie = new Cookie(TOKEN, authToken);
			cookie.setPath("/");
			response.addCookie(cookie);
			response.addHeader(TOKEN, authToken);
			return true;
		}
		return false;
	}

	private byte[] decodeFromBase64(String base64String) {
		return Base64.getDecoder().decode(base64String);
	}

	private String createJwt(Key key, String loanId) {
		try {
			// Your JWT creation logic using the specified key
			return Jwts.builder().setSubject(loanId).signWith(key).compact();
		} catch (Exception e) {
			System.err.println("Error creating JWT: " + e.getMessage());
			return null;
		}
	}

	public String getToken(HttpServletRequest request) {
		String header = request.getHeader(TOKEN);
		if (header == null) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if (TOKEN.equalsIgnoreCase(cookie.getName())) {
						header = cookie.getValue();
						continue;
					}
				}
			}
		}
		if (header == null) {
			return null;
		} else {
			return header;
		}
	}
	
	
	public void clearCookies(HttpServletRequest request, HttpServletResponse res) {
		if (request != null && res != null) {
			final Cookie authToken = new Cookie(TOKEN, null);
			authToken.setMaxAge(0);
			authToken.setPath("/");
			res.addCookie(authToken);
			res.setHeader(TOKEN, "");
		}
	}

}
