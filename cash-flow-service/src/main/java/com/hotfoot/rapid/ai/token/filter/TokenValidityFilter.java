package com.hotfoot.rapid.ai.token.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.token.TokenCreationService;
import com.hotfoot.rapid.ai.token.datamodel.TokenCache;
import com.hotfoot.rapid.ai.token.repository.TokenCacheRepository;

import java.io.IOException;
import java.util.Date;

@Component
public class TokenValidityFilter implements Filter {
	
	@Autowired
	private TokenCreationService tokenService;
	
	@Autowired
	private TokenCacheRepository tokenCacheRepo;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
        	String tokenFromRequest = tokenService.getToken((HttpServletRequest) request);
        	TokenCache activeToken = tokenCacheRepo.findByToken(tokenFromRequest);
        	if(activeToken != null) {
        		activeToken.setModifiedDate(new Date());
        		tokenCacheRepo.save(activeToken);
        	}
            // Call the next filter in the chain (or the servlet if this is the last filter)
            chain.doFilter(request, response);
        } catch (Exception e) {
			System.out.println("unable to update token's validity");
		}
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
