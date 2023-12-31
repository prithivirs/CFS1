package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class BankStatementResponse {

    @JsonProperty("docId")
    private String docId;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("bankStatement")
    private Boolean bankStatement;
    
    @JsonProperty("periodStart")
    private String periodStart;
    
    @JsonProperty("periodEnd")
    private String periodEnd;
    
    @JsonProperty("data")
    private List<BankDataDetails> data;
    
    @JsonProperty("error")
	private boolean error;

}

