package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class FundReceived {

	@JsonProperty("month")
	private String month;
	
	@JsonProperty("totalAmount")
	private Object totalAmount;
	
	@JsonProperty("transactions")
	private List<TransactionDetails> transactions;
}
