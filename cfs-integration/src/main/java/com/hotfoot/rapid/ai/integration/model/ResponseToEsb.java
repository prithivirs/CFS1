package com.hotfoot.rapid.ai.integration.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseToEsb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1813487267398735037L;
	
	
	@JsonProperty("status")
	private String status;

}
