package com.hotfoot.rapid.ai.document.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2879273457632262635L;
	
	@JsonProperty("docId")
	private String documentId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("bank_statement")
	private String bankStatement;
	
	@JsonProperty("period_start")
	private String periodStart;
	
	@JsonProperty("period_end")
	private String periodEnd;
	
	@JsonProperty("fileName")
	private String fileName;
	
	@JsonProperty("uploadTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date uploadTime;
	
	@JsonProperty("ocrFile")
	private String ocrFile;
	
	@JsonProperty("fileCount")
	private Integer fileCount;
	
	@JsonProperty("totalPages")
	private Integer totalPages;
	
	@JsonProperty("error")
	private String error;

}
