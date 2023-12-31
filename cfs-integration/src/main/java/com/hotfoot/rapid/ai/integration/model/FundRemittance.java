package com.hotfoot.rapid.ai.integration.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class FundRemittance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5918356883638157466L;

	@JsonProperty("month")
	private String month;
	
	@JsonProperty("totalAmount")
	private Object totalAmount;
	
	@JsonProperty("transactions")
	private List<TransactionDetails> transactions;
}

