package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DailyBalances {

    @JsonProperty("month")
    private String month;
    
    @JsonProperty("dailyBalance")
    private List<DailyBalance> dailyBalance;

 

}
