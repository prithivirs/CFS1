package com.hotfoot.rapid.ai.integration.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ChequeBounce implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 6488126204472755059L;

	@JsonProperty("month")
	private String month;

	@JsonProperty("transactions")
	private List<Transaction> transactions;

}
