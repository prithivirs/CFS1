package com.hotfoot.rapid.ai.security.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotfoot.rapid.ai.security.datamodel.TokenCache;

@Repository
public interface TokenCacheRepository extends JpaRepository<TokenCache, Long> {

	public TokenCache findByLoanId(String loanId);

	public TokenCache findByToken(String token);

	@Query("SELECT e FROM TokenCache e WHERE e.modifiedDate IS NULL AND e.createdDate <= :cutoffDate")
	List<TokenCache> findEntriesWithNullModifiedDateAndOlderCreatedDate(@Param("cutoffDate") Date cutoffDate);

	@Query("SELECT e FROM TokenCache e WHERE e.modifiedDate IS NOT NULL AND e.modifiedDate < :cutoffDate")
	List<TokenCache> findEntriesWithModifiedDateBeforeCutoffDate(@Param("cutoffDate") Date cutoffDate);

}
