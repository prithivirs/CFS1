package com.hotfoot.rapid.ai.security.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthenticationRequest {
	
	@JsonProperty("secret_key")
	private String secretKey;
	
	@JsonProperty("client")
	private String client;
	
	@JsonProperty("request")
	private ClientRequest request;
	
}
