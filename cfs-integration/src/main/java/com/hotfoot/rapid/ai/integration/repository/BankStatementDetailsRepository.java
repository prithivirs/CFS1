package com.hotfoot.rapid.ai.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotfoot.rapid.ai.integration.datamodel.BankStatementDetails;


public interface BankStatementDetailsRepository extends JpaRepository<BankStatementDetails, Long>{

	
	BankStatementDetails findByLoanId(String loanID);
	
	BankStatementDetails findByCustomerReferenceNo(String customerRef);
	
	List<BankStatementDetails> findByLoanIdAndCustomerReferenceNo(String loanID, String customerRef);
}
