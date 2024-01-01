package com.hotfoot.rapid.ai.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisDatum {

    @JsonProperty("month")
    private String month;
    
    @JsonProperty("noOfCreditTransactions")
    private Integer noOfCreditTransactions;
    
    @JsonProperty("creditTransactionsAmount")
    private Double creditTransactionsAmount;
    
    @JsonProperty("noOfDebitTransactions")
    private Integer noOfDebitTransactions;
    
    @JsonProperty("debitTransactionsAmount")
    private Double debitTransactionsAmount;
    
    @JsonProperty("noOfNetCreditTransactions")
    private Integer noOfNetCreditTransactions;
    
    @JsonProperty("netCreditTransactionsAmount")
    private Double netCreditTransactionsAmount;
    
    @JsonProperty("noOfNetDebitTransactions")
    private Integer noOfNetDebitTransactions;
    
    @JsonProperty("netDebitTransactionsAmount")
    private Double netDebitTransactionsAmount;
    
    @JsonProperty("noOfCashWithdrawals")
    private Integer noOfCashWithdrawals;
    
    @JsonProperty("cashWithdrawalsAmount")
    private Double cashWithdrawalsAmount;
    
    @JsonProperty("noOfATMWithdrawals")
    private Integer noOfATMWithdrawals;
    
    @JsonProperty("atmWithdrawalsAmount")
    private Double atmWithdrawalsAmount;
    
    @JsonProperty("noOfCashDeposits")
    private Integer noOfCashDeposits;
    
    @JsonProperty("cashDepositsAmount")
    private Double cashDepositsAmount;
    
    @JsonProperty("noOfChequeBounceInward")
    private Integer noOfChequeBounceInward;
    
    @JsonProperty("chequeBounceInwardAmount")
    private Double chequeBounceInwardAmount;
    
    @JsonProperty("noOfChequeBounceOutward")
    private Integer noOfChequeBounceOutward;
    
    @JsonProperty("chequeBounceOutwardAmount")
    private Double chequeBounceOutwardAmount;
    
    @JsonProperty("noOfPaymentBounceInward")
    private Integer noOfPaymentBounceInward;
    
    @JsonProperty("paymentBounceInwardAmount")
    private Double paymentBounceInwardAmount;
    
    @JsonProperty("noOfPaymentBounceOutward")
    private Integer noOfPaymentBounceOutward;
    
    @JsonProperty("paymentBounceOutwardAmount")
    private Double paymentBounceOutwardAmount;
    
    @JsonProperty("noOfChequeDeposits")
    private Integer noOfChequeDeposits;
    
    @JsonProperty("chequeDepositsAmount")
    private Double chequeDepositsAmount;
    
    @JsonProperty("noOfChequeIssued")
    private Integer noOfChequeIssued;
    
    @JsonProperty("chequeIssuedAmount")
    private Double chequeIssuedAmount;
    
    @JsonProperty("noOfEMI")
    private Integer noOfEMI;
    
    @JsonProperty("totalEMIAmount")
    private Double totalEMIAmount;
    
    @JsonProperty("noOfEMIBounce")
    private Integer noOfEMIBounce;
    
    @JsonProperty("totalEMIBounceAmount")
    private Double totalEMIBounceAmount;
    
    @JsonProperty("noOfLoanDisbursal")
    private Integer noOfLoanDisbursal;
    
    @JsonProperty("loanDisbursalAmount")
    private Double loanDisbursalAmount;
    
    @JsonProperty("salaryAmount")
    private Double salaryAmount;
    
    @JsonProperty("noOfMinimumBalanceCharges")
    private Integer noOfMinimumBalanceCharges;
    
    @JsonProperty("minimumEODBalance")
    private Double minimumEODBalance;
    
    @JsonProperty("maximumEODBalance")
    private Double maximumEODBalance;
    
    @JsonProperty("averageEODBalance")
    private Double averageEODBalance;

    @JsonProperty("noOfPenalCharges")
    private long  noOfPenalCharges;
    
  	@JsonProperty("totalPenalChargesAmount")
  	private double totalPenalChargesAmount;
  	
   	@JsonProperty("noOfBankCharges")
   	private long noOfBankCharges;
   	
    @JsonProperty("totalBankChargesAmount")
    private double totalBankChargesAmount;
    
    @JsonProperty("cashDepositPercentage")
    private double cashDepositPercentage;
    
    @JsonProperty("totalInterestReceived")
    private double totalInterestReceived;
    
    @JsonProperty("totalInterestPaid")
    private double totalInterestPaid;
    
}

