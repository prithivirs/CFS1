package com.hotfoot.rapid.ai.integration.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3213462993090942652L;
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("transactionDate")
	private String transactionDate;
	
	@JsonProperty("narration")
	private String narration;
	
	@JsonProperty("paymentMode")
	private String paymentMode;
	
	@JsonProperty("paymentCategory")
	private String paymentCategory;
	
	@JsonProperty("cheque")
	private String cheque;
	
	@JsonProperty("amount")
	private Integer amount;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("openingBalance")
	private Double openingBalance;
	
	@JsonProperty("closingBalance")
	private Double closingBalance;
	
	@JsonProperty("monthYear")
	private String monthYear;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("ignorableTransaction")
	private String ignorableTransaction;
	
	@JsonProperty("holiday")
	private String holiday;
}
