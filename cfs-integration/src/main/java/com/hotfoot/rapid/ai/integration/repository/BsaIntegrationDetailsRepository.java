package com.hotfoot.rapid.ai.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotfoot.rapid.ai.integration.datamodel.BsaIntgerationDetails;

@Repository
public interface BsaIntegrationDetailsRepository extends JpaRepository<BsaIntgerationDetails, Long>{
	
	BsaIntgerationDetails findByRequestId(String requestId);

	BsaIntgerationDetails findByDocumentId(String documentId);
	
	List<BsaIntgerationDetails> findByLRequestIdAndDocumentId(String requestId, String documentId);
	 
	BsaIntgerationDetails findByLoanIdAndCustomerReferenceNoAndRequestId(String loanId, String customerRef, String requestId);
	
	

	
}
