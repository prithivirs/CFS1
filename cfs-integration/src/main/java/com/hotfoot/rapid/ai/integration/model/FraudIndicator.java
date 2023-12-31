package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FraudIndicator {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("transactions")
    private List<Transaction> transactions;

   
}
