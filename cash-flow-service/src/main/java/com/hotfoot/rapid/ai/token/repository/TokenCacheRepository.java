package com.hotfoot.rapid.ai.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotfoot.rapid.ai.token.datamodel.TokenCache;

@Repository
public interface TokenCacheRepository extends JpaRepository<TokenCache, Long>{
	
	public TokenCache findByLoanId(String loanId);
	
	public TokenCache findByToken(String token);

}
