package com.hotfoot.rapid.ai.integration.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("transactionDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date transactionDate;
    
    @JsonProperty("narration")
    private String narration;
    
    @JsonProperty("paymentMode")
    private String paymentMode;
    
    @JsonProperty("paymentCategory")
    private String paymentCategory;
    
    @JsonProperty("cheque")
    private String cheque;
    
    @JsonProperty("amount")
    private Double amount;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("openingBalance")
    private Double openingBalance;
    
    @JsonProperty("closingBalance")
    private Double closingBalance;
    
    @JsonProperty("monthYear")
    private String monthYear;
   
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("ignorableTransaction")
    private Boolean ignorableTransaction;
    
    @JsonProperty("holiday")
    private Boolean holiday;

  

}