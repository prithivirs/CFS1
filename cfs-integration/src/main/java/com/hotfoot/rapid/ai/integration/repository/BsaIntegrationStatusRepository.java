package com.hotfoot.rapid.ai.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotfoot.rapid.ai.integration.datamodel.BsaIntegrationStatus;

public interface BsaIntegrationStatusRepository extends JpaRepository<BsaIntegrationStatus, Long>{
	
	BsaIntegrationStatus findByDocumentId(String documentId);
	
	BsaIntegrationStatus findByDocumentIdAndStatus(String documentId, String Status);
	
	BsaIntegrationStatus findByRequestIdAndCustomerId(String requestId, String customerId);

}
