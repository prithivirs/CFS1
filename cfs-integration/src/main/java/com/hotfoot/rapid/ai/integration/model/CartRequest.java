package com.hotfoot.rapid.ai.integration.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class CartRequest implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5864919635096131356L;

	public CartRequest() {
	}
	
	@JsonProperty("RequestId")
	private String requestId;
	
	@JsonProperty("Source")
	private String source;
	
	@JsonProperty("filename")
	private String fileName;
	
	@JsonProperty("file")
	private String fileContent;


}
