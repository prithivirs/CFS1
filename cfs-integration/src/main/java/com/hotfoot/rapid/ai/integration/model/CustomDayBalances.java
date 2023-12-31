package com.hotfoot.rapid.ai.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomDayBalances {

	@JsonProperty("1")
	private Double balOn1;

	@JsonProperty("10")
	private Double balOn10;

	@JsonProperty("5")
	private Double balOn5;

	@JsonProperty("15")
	private Double balon15;

	@JsonProperty("20")
	private Double balon20;

	@JsonProperty("25")
	private Double balOn25;

}

