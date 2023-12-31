package com.hotfoot.rapid.ai.integration.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotfoot.rapid.ai.integration.model.MonthlyBalancesDetail;
import com.hotfoot.rapid.ai.integration.model.MonthlyBalancesDetailsGrandTotal;
import com.hotfoot.rapid.ai.integration.model.MonthlyCreditsDetails;
import com.hotfoot.rapid.ai.integration.model.MonthlyCreditsDetailsGrandTotal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BsaCreditData {
	@JsonProperty("accountHolderName")
	public String getAccountHolderName() {
		return this.accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	String accountHolderName;

	@JsonProperty("accountNumber")
	public String getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public String toString() {
		return "BsaCreditData [accountHolderName=" + accountHolderName + ", accountNumber=" + accountNumber + ", ifsc=" + ifsc + ", bankName=" + bankName + ", branchName="
				+ branchName + ", accountType=" + accountType + ", startDate=" + startDate + ", endDate=" + endDate + ", totalCreditCount=" + totalCreditCount
				+ ", totalDebitCount=" + totalDebitCount + ", avgMonthlyBalance=" + avgMonthlyBalance + ", avgMonthlyCredits=" + avgMonthlyCredits + ", inwardChequeBounce="
				+ inwardChequeBounce + ", outwardChequeBounce=" + outwardChequeBounce + ", totalEMICount=" + totalEMICount + ", totalEMIAmount=" + totalEMIAmount
				+ ", totalSalaryAmount=" + totalSalaryAmount + ", monthlyBalancesDetails=" + monthlyBalancesDetails + ", monthlyBalancesDetailsGrandTotal="
				+ monthlyBalancesDetailsGrandTotal + ", monthlyCreditsDetails=" + monthlyCreditsDetails + ", monthlyCreditsDetailsGrandTotal=" + monthlyCreditsDetailsGrandTotal
				+ "]";
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	String accountNumber;

	@JsonProperty("ifsc")
	public String getIfsc() {
		return this.ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	String ifsc;

	@JsonProperty("bankName")
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	String bankName;

	@JsonProperty("branchName")
	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	String branchName;

	@JsonProperty("accountType")
	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	String accountType;

	@JsonProperty("startDate")
	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	String startDate;

	@JsonProperty("endDate")
	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	String endDate;

	@JsonProperty("totalCreditCount")
	public int getTotalCreditCount() {
		return this.totalCreditCount;
	}

	public void setTotalCreditCount(int totalCreditCount) {
		this.totalCreditCount = totalCreditCount;
	}

	int totalCreditCount;

	@JsonProperty("totalDebitCount")
	public int getTotalDebitCount() {
		return this.totalDebitCount;
	}

	public void setTotalDebitCount(int totalDebitCount) {
		this.totalDebitCount = totalDebitCount;
	}

	int totalDebitCount;

	@JsonProperty("avgMonthlyBalance")
	public double getAvgMonthlyBalance() {
		return this.avgMonthlyBalance;
	}

	public void setAvgMonthlyBalance(double avgMonthlyBalance) {
		this.avgMonthlyBalance = avgMonthlyBalance;
	}

	double avgMonthlyBalance;

	@JsonProperty("avgMonthlyCredits")
	public double getAvgMonthlyCredits() {
		return this.avgMonthlyCredits;
	}

	public void setAvgMonthlyCredits(double avgMonthlyCredits) {
		this.avgMonthlyCredits = avgMonthlyCredits;
	}

	double avgMonthlyCredits;

	@JsonProperty("inwardChequeBounce")
	public int getInwardChequeBounce() {
		return this.inwardChequeBounce;
	}

	public void setInwardChequeBounce(int inwardChequeBounce) {
		this.inwardChequeBounce = inwardChequeBounce;
	}

	int inwardChequeBounce;

	@JsonProperty("outwardChequeBounce")
	public int getOutwardChequeBounce() {
		return this.outwardChequeBounce;
	}

	public void setOutwardChequeBounce(int outwardChequeBounce) {
		this.outwardChequeBounce = outwardChequeBounce;
	}

	int outwardChequeBounce;

	@JsonProperty("totalEMICount")
	public int getTotalEMICount() {
		return this.totalEMICount;
	}

	public void setTotalEMICount(int totalEMICount) {
		this.totalEMICount = totalEMICount;
	}

	int totalEMICount;

	@JsonProperty("totalEMIAmount")
	public double getTotalEMIAmount() {
		return this.totalEMIAmount;
	}

	public void setTotalEMIAmount(double totalEMIAmount) {
		this.totalEMIAmount = totalEMIAmount;
	}

	double totalEMIAmount;

	@JsonProperty("totalSalaryAmount")
	public double getTotalSalaryAmount() {
		return this.totalSalaryAmount;
	}

	public void setTotalSalaryAmount(double totalSalaryAmount) {
		this.totalSalaryAmount = totalSalaryAmount;
	}

	double totalSalaryAmount;

	@JsonProperty("monthlyBalancesDetails")
	public ArrayList<MonthlyBalancesDetail> getMonthlyBalancesDetails() {
		return this.monthlyBalancesDetails;
	}

	public void setMonthlyBalancesDetails(ArrayList<MonthlyBalancesDetail> monthlyBalancesDetails) {
		this.monthlyBalancesDetails = monthlyBalancesDetails;
	}

	ArrayList<MonthlyBalancesDetail> monthlyBalancesDetails;

	@JsonProperty("monthlyBalancesDetailsGrandTotal")
	public MonthlyBalancesDetailsGrandTotal getMonthlyBalancesDetailsGrandTotal() {
		return this.monthlyBalancesDetailsGrandTotal;
	}

	public void setMonthlyBalancesDetailsGrandTotal(MonthlyBalancesDetailsGrandTotal monthlyBalancesDetailsGrandTotal) {
		this.monthlyBalancesDetailsGrandTotal = monthlyBalancesDetailsGrandTotal;
	}

	MonthlyBalancesDetailsGrandTotal monthlyBalancesDetailsGrandTotal;

	@JsonProperty("monthlyCreditsDetails")
	public ArrayList<MonthlyCreditsDetails> getMonthlyCreditsDetails() {
		return this.monthlyCreditsDetails;
	}

	public void setMonthlyCreditsDetails(ArrayList<MonthlyCreditsDetails> monthlyCreditsDetails) {
		this.monthlyCreditsDetails = monthlyCreditsDetails;
	}

	ArrayList<MonthlyCreditsDetails> monthlyCreditsDetails;

	@JsonProperty("monthlyCreditsDetailsGrandTotal")
	public MonthlyCreditsDetailsGrandTotal getMonthlyCreditsDetailsGrandTotal() {
		return this.monthlyCreditsDetailsGrandTotal;
	}

	public void setMonthlyCreditsDetailsGrandTotal(MonthlyCreditsDetailsGrandTotal monthlyCreditsDetailsGrandTotal) {
		this.monthlyCreditsDetailsGrandTotal = monthlyCreditsDetailsGrandTotal;
	}

	MonthlyCreditsDetailsGrandTotal monthlyCreditsDetailsGrandTotal;
}

