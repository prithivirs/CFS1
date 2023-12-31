package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CamAnalysisData {

    @JsonProperty("odCcLimit")
    private Double odCcLimit;
    
    @JsonProperty("inwardReturnCount")
    private Integer inwardReturnCount;
    
    @JsonProperty("outwardReturnCount")
    private Integer outwardReturnCount;
    
    @JsonProperty("inwardReturnAmount")
    private Double inwardReturnAmount;
    
    @JsonProperty("outwardReturnAmount")
    private Double outwardReturnAmount;
    
    @JsonProperty("totalNetCredits")
    private Double totalNetCredits;
    
    @JsonProperty("averageBalance")
    private Double averageBalance;
    
    @JsonProperty("customAverageBalance")
    private Double customAverageBalance;
    
    @JsonProperty("averageBalanceLastSixMonth")
    private Double averageBalanceLastSixMonth;
    
    @JsonProperty("averageBalanceLastTwelveMonth")
    private Double averageBalanceLastTwelveMonth;
    
    @JsonProperty("averageReceiptLastSixMonth")
    private Double averageReceiptLastSixMonth;
    
    @JsonProperty("averageReceiptLastTwelveMonth")
    private Double averageReceiptLastTwelveMonth;
   
    @JsonProperty("camAnalysisMonthly")
    private List<CamAnalysisMonthly> camAnalysisMonthly;

   
}

