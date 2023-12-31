package com.hotfoot.rapid.ai.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankDataDetails {

	@JsonProperty("bankName")
	private String bankName;

	@JsonProperty("accountNumber")
	private String accountNumber;

	@JsonProperty("accountName")
	private String accountName;

	@JsonProperty("ifscCode")
	private String ifscCode;

	@JsonProperty("accountType")
	private String accountType;

	@JsonProperty("productType")
	private String productType;

	@JsonProperty("periodStart")
	private String periodStart;

	@JsonProperty("periodEnd")
	private String periodEnd;

	@JsonProperty("email")
	private String email;

	@JsonProperty("panNumber")
	private String panNumber;

	@JsonProperty("documentType")
	private String documentType;

	@JsonProperty("camAnalysisData")
	private CamAnalysisData camAnalysisData;

	@JsonProperty("analysisData")
	private List<AnalysisDatum> analysisData;

	@JsonProperty("transactions")
	private List<Transaction> transactions;

	@JsonProperty("fundRemittance")
	private List<FundRemittance> fundRemittance;

	@JsonProperty("fundReceived")
	private List<FundReceived> fundReceived;

	@JsonProperty("dailyBalances")
	private List<DailyBalances> dailyBalances;

	@JsonProperty("fraudIndicators")
	private List<FraudIndicator> fraudIndicators;

	@JsonProperty("fraudScore")
	private Double fraudScore;

	@JsonProperty("salary")
	private List<Object> salary;

	@JsonProperty("emi")
	private List<EmiDetails> emi;

	@JsonProperty("chequeBounces")
	private List<ChequeBounce> chequeBounces;

	@JsonProperty("gstDetails")
	private String gstDetails;

	@JsonProperty("matchedCibil")
	private String matchedCibil;

	@JsonProperty("unmatchedCibil")
	private String unmatchedCibil;

	@JsonProperty("month")
	private String month;

	@JsonProperty("totalAmount")
	private Object totalAmount;

	@JsonProperty("billPayments")
	private Object billPayments;

	@JsonProperty("statutoryPayments")
	private Object statutoryPayments;

	@JsonProperty("creditCardSettlement")
	private Object creditCardSettlement;

	@JsonProperty("form26AS")
	private Object form26AS;

	@JsonProperty("itrV")
	private Object itrV;
	
	@JsonProperty("bsaCreditData")
	private BsaCreditData bsaCreditData;
}

