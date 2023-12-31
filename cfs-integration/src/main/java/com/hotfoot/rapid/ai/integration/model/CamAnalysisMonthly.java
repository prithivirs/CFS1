package com.hotfoot.rapid.ai.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CamAnalysisMonthly {

	@JsonProperty("month")
	private String month;

	@JsonProperty("noOfCredit")
	private Integer noOfCredit;

	@JsonProperty("netCreditAmount")
	private Double netCreditAmount;

	@JsonProperty("internalCredits")
	private Double internalCredits;

	@JsonProperty("grossCreditAmount")
	private Double grossCreditAmount;

	@JsonProperty("noOfDebit")
	private Integer noOfDebit;

	@JsonProperty("netDebitAmount")
	private Double netDebitAmount;

	@JsonProperty("internalDebit")
	private Double internalDebit;

	@JsonProperty("grossDebitAmount")
	private Double grossDebitAmount;

	@JsonProperty("noOfInwardReturn")
	private Integer noOfInwardReturn;

	@JsonProperty("inwardReturn")
	private Double inwardReturn;

	@JsonProperty("noOfOutwardReturn")
	private Integer noOfOutwardReturn;

	@JsonProperty("outwardReturn")
	private Double outwardReturn;

	@JsonProperty("loanDisbursal")
	private Double loanDisbursal;

	@JsonProperty("customDayBalances")
	private CustomDayBalances customDayBalances;

	@JsonProperty("monthlyAvgInclOdCcLimit")
	private Double monthlyAvgInclOdCcLimit;

	@JsonProperty("maxContinuousOverdrawings")
	private Long maxContinuousOverdrawings;

	@JsonProperty("instancesOfOverdrawings")
	private Double instancesOfOverdrawings;

	@JsonProperty("maxOverdrawnAmount")
	private Double maxOverdrawnAmount;

	@JsonProperty("maxInterestServicingDays")
	private Double maxInterestServicingDays;

	@JsonProperty("averageNegativeEODBalance")
	private Double averageNegativeEODBalance;

}
