package com.hotfoot.rapid.ai.security.scheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.security.datamodel.TokenCache;
import com.hotfoot.rapid.ai.security.repository.TokenCacheRepository;

@Component
public class LogoutScheduler {

	@Autowired
	private TokenCacheRepository tokenCacheRepo;

	@Scheduled(fixedRate = 30 * 60 * 1000) // Run every 30 minutes
	public void yourScheduledTask() {
		Date cutoffDate = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
		List<TokenCache> staleTokens = tokenCacheRepo.findEntriesWithNullModifiedDateAndOlderCreatedDate(cutoffDate);
		List<TokenCache> staleCutOffTokens = tokenCacheRepo.findEntriesWithModifiedDateBeforeCutoffDate(cutoffDate);
		tokenCacheRepo.deleteAllInBatch(staleCutOffTokens);
		tokenCacheRepo.deleteAllInBatch(staleTokens);
	}

}
