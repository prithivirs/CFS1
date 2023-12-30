package com.hotfoot.rapid.ai.token.pojo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClientRequest {

	@JsonProperty("loan_id")
	private String loanId;
	
	@JsonProperty("loan_type")
	private String loanType;
	
	@JsonProperty("scheme_type")
	private String schemeType;
	
	@JsonProperty("loan_amount")
	private String loanAmount;
	
	@JsonProperty("industry")
	private String industry;

	@JsonProperty("customers")
	private Set<ClientRequestCustomers> customers;
	
	
}
