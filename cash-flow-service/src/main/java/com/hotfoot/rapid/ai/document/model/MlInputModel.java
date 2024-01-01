package com.hotfoot.rapid.ai.document.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MlInputModel {

	@JsonProperty("net_interest_12m")
	private long netInterest12M;
	
}
