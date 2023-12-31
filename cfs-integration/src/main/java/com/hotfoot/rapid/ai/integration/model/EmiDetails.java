package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmiDetails {

    @JsonProperty("commonEntity")
    private String commonEntity;
    
    @JsonProperty("amount")
    private Double amount;
    
    @JsonProperty("transactions")
    private List<Transaction> transactions;

    
}
