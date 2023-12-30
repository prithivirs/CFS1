package com.hotfoot.rapid.ai.security.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.security.datamodel.TokenCache;
import com.hotfoot.rapid.ai.security.repository.TokenCacheRepository;
import com.hotfoot.rapid.ai.security.service.LogoutService;
import com.hotfoot.rapid.ai.security.service.TokenCreationService;

import java.io.IOException;
import java.util.Date;

@Component
public class TokenAuthenticationFilter implements Filter {

	@Autowired
	private TokenCreationService tokenService;

	@Autowired
	private TokenCacheRepository tokenCacheRepo;

	@Autowired
	private LogoutService logoutService;
	
	@Value("#{'${whitelisted.domains:localhost}'.split(',')}")
	private String[] whiteListedDomains;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization code, if needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			String referrer = ((HttpServletRequest) request).getHeader(HttpHeaders.REFERER);
			boolean isValidReferrer = true;
			for (String domainName : whiteListedDomains) {
				if (!referrer.startsWith(domainName.trim())) {
					isValidReferrer = false;
					continue;
				}
			}
			String tokenFromRequest = tokenService.getToken((HttpServletRequest) request);
			if (tokenFromRequest == null || referrer == null || !isValidReferrer) {
				logoutService.logout((HttpServletRequest) request, (HttpServletResponse) response);
			} else {
				TokenCache activeToken = tokenCacheRepo.findByToken(tokenFromRequest);
				if (activeToken != null) {
					activeToken.setModifiedDate(new Date());
					tokenCacheRepo.save(activeToken);
				}
			}
			// Call the next filter in the chain (or the servlet if this is the last filter)
		} catch (Exception e) {
			System.out.println("unable to update token's validity");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Cleanup code, if needed
	}
}
