package com.hotfoot.rapid.ai.integration.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CartUploadRequest implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3882509520238442761L;

	@JsonProperty("request_id")
	private String requestid;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("document_id")
	private String documentId;
	
	@JsonProperty("data")
	private String bankstatementReport;

}
