package com.hotfoot.rapid.ai.integration.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class DailyBalance {

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;
    
    @JsonProperty("openingBalance")
    private Double openingBalance;
    
    @JsonProperty("closingBalance")
    private Double closingBalance;

}
