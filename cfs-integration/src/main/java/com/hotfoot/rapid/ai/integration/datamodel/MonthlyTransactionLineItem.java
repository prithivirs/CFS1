package com.hotfoot.rapid.ai.integration.datamodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class MonthlyTransactionLineItem {

	@Column(name = "month")
	@JsonProperty("month")
	private String month;

	@Column(name = "year")
	@JsonProperty("year")
	private int year;

	@Column(name = "balance_as_on_1")
	@JsonProperty("balance_as_on_1")
	private double balanceAsOn1;

	@Column(name = "balance_as_on_5")
	@JsonProperty("balance_as_on_5")
	private double balanceAsOn5;

	@Column(name = "balance_as_on_10")
	@JsonProperty("balance_as_on_10")
	private double balanceAsOn10;

	@Column(name = "balance_as_on_15")
	@JsonProperty("balance_as_on_15")
	private double balanceAsOn15;

	@Column(name = "balance_as_on_25")
	@JsonProperty("balance_as_on_25")
	private double balanceAsOn25;

	@Column(name = "cc_interest_debit")
	@JsonProperty("cc_interest_debit")
	private double ccInterestDebit;

	@Column(name = "abb")
	@JsonProperty("abb")
	private double abb;

	@Column(name = "balance_as_on_30")
	@JsonProperty("balance_as_on_30")
	private double balanceAsOn30;

	@Column(name = "monthly_credits")
	@JsonProperty("monthly_credits")
	private double monthlyCredits;

	@Column(name = "monthly_debits")
	@JsonProperty("monthly_debits")
	private double monthlyDebits;

	@Column(name = "monthly_average")
	@JsonProperty("monthly_average")
	private double monthlyAverage;

	@Column(name = "no_of_monthly_debits")
	@JsonProperty("no_of_monthly_debits")
	private int noOfMonthlyDebits;

	@Column(name = "no_of_monthly_credits")
	@JsonProperty("no_of_monthly_credits")
	private int noOfMonthlyCredits;

	@Column(name = "inward_chq_bounces")
	@JsonProperty("inward_chq_bounces")
	private int inwardChqBounces;

	@Column(name = "outward_chq_bounces")
	@JsonProperty("outward_chq_bounces")
	private int outwardChqBounces;

	@Column(name = "inward_chq_bounces_percentage")
	@JsonProperty("inward_chq_bounces_percentage")
	private int inwardChqBouncesPercentage;

	@Column(name = "outward_chq_bounces_percentage")
	@JsonProperty("outward_chq_bounces_percentage")
	private int outwardChqBouncesPercentage;

	@Column(name = "average_utilization")
	@JsonProperty("average_utilization")
	private double averageUtilization;

	@Column(name = "balance_as_on_20")
	@JsonProperty("balance_as_on_20")
	private double balanceAsOn20;

	public MonthlyTransactionLineItem() {
		// TODO Auto-generated constructor stub
	}

	public double getBalanceAsOn20() {
		return balanceAsOn20;
	}

	public void setBalanceAsOn20(double balanceAsOn20) {
		this.balanceAsOn20 = balanceAsOn20;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getBalanceAsOn1() {
		return balanceAsOn1;
	}

	public void setBalanceAsOn1(double balanceAsOn1) {
		this.balanceAsOn1 = balanceAsOn1;
	}

	public double getBalanceAsOn5() {
		return balanceAsOn5;
	}

	public void setBalanceAsOn5(double balanceAsOn5) {
		this.balanceAsOn5 = balanceAsOn5;
	}

	public double getBalanceAsOn10() {
		return balanceAsOn10;
	}

	public void setBalanceAsOn10(double balanceAsOn10) {
		this.balanceAsOn10 = balanceAsOn10;
	}

	public double getBalanceAsOn15() {
		return balanceAsOn15;
	}

	public void setBalanceAsOn15(double balanceAsOn15) {
		this.balanceAsOn15 = balanceAsOn15;
	}

	public double getMonthlyCredits() {
		return monthlyCredits;
	}

	public void setMonthlyCredits(double monthlyCredits) {
		this.monthlyCredits = monthlyCredits;
	}

	public double getMonthlyDebits() {
		return monthlyDebits;
	}

	public void setMonthlyDebits(double monthlyDebits) {
		this.monthlyDebits = monthlyDebits;
	}

	public double getMonthlyAverage() {
		return monthlyAverage;
	}

	public void setMonthlyAverage(double monthlyAverage) {
		this.monthlyAverage = monthlyAverage;
	}

	public int getInwardChqBounces() {
		return inwardChqBounces;
	}

	public void setInwardChqBounces(int inwardChqBounces) {
		this.inwardChqBounces = inwardChqBounces;
	}

	public int getOutwardChqBounces() {
		return outwardChqBounces;
	}

	public void setOutwardChqBounces(int outwardChqBounces) {
		this.outwardChqBounces = outwardChqBounces;
	}

	public int getNoOfMonthlyDebits() {
		return noOfMonthlyDebits;
	}

	public void setNoOfMonthlyDebits(int noOfMonthlyDebits) {
		this.noOfMonthlyDebits = noOfMonthlyDebits;
	}

	public double getNoOfMonthlyCredits() {
		return noOfMonthlyCredits;
	}

	public void setNoOfMonthlyCredits(int noOfMonthlyCredits) {
		this.noOfMonthlyCredits = noOfMonthlyCredits;
	}

	public int getInwardChqBouncesPercentage() {
		return inwardChqBouncesPercentage;
	}

	public void setInwardChqBouncesPercentage(int inwardChqBouncesPercentage) {
		this.inwardChqBouncesPercentage = inwardChqBouncesPercentage;
	}

	public int getOutwardChqBouncesPercentage() {
		return outwardChqBouncesPercentage;
	}

	public void setOutwardChqBouncesPercentage(int outwardChqBouncesPercentage) {
		this.outwardChqBouncesPercentage = outwardChqBouncesPercentage;
	}

	public double getBalanceAsOn25() {
		return balanceAsOn25;
	}

	public void setBalanceAsOn25(double balanceAsOn25) {
		this.balanceAsOn25 = balanceAsOn25;
	}

	public double getCcInterestDebit() {
		return ccInterestDebit;
	}

	public void setCcInterestDebit(double ccInterestDebit) {
		this.ccInterestDebit = ccInterestDebit;
	}

	public double getAbb() {
		return abb;
	}

	public void setAbb(double abb) {
		this.abb = abb;
	}

	public double getBalanceAsOn30() {
		return balanceAsOn30;
	}

	public void setBalanceAsOn30(double balanceAsOn30) {
		this.balanceAsOn30 = balanceAsOn30;
	}

	public double getAverageUtilization() {
		return averageUtilization;
	}

	public void setAverageUtilization(double averageUtilization) {
		this.averageUtilization = averageUtilization;
	}

	@Override
	public String toString() {
		return "MonthlyTransactionLineItem [month=" + month + ", year=" + year + ", balanceAsOn1=" + balanceAsOn1
				+ ", balanceAsOn5=" + balanceAsOn5 + ", balanceAsOn10=" + balanceAsOn10 + ", balanceAsOn15="
				+ balanceAsOn15 + ", balanceAsOn25=" + balanceAsOn25 + ", ccInterestDebit=" + ccInterestDebit + ", abb="
				+ abb + ", balanceAsOn30=" + balanceAsOn30 + ", monthlyCredits=" + monthlyCredits + ", monthlyDebits="
				+ monthlyDebits + ", monthlyAverage=" + monthlyAverage + ", noOfMonthlyDebits=" + noOfMonthlyDebits
				+ ", noOfMonthlyCredits=" + noOfMonthlyCredits + ", inwardChqBounces=" + inwardChqBounces
				+ ", outwardChqBounces=" + outwardChqBounces + ", inwardChqBouncesPercentage="
				+ inwardChqBouncesPercentage + ", outwardChqBouncesPercentage=" + outwardChqBouncesPercentage
				+ ", averageUtilization=" + averageUtilization + ", balanceAsOn20=" + balanceAsOn20 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(abb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(averageUtilization);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn10);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn15);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn20);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn25);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn30);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceAsOn5);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ccInterestDebit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + inwardChqBounces;
		result = prime * result + inwardChqBouncesPercentage;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		temp = Double.doubleToLongBits(monthlyAverage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthlyCredits);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthlyDebits);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + noOfMonthlyCredits;
		result = prime * result + noOfMonthlyDebits;
		result = prime * result + outwardChqBounces;
		result = prime * result + outwardChqBouncesPercentage;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyTransactionLineItem other = (MonthlyTransactionLineItem) obj;
		if (Double.doubleToLongBits(abb) != Double.doubleToLongBits(other.abb))
			return false;
		if (Double.doubleToLongBits(averageUtilization) != Double.doubleToLongBits(other.averageUtilization))
			return false;
		if (Double.doubleToLongBits(balanceAsOn1) != Double.doubleToLongBits(other.balanceAsOn1))
			return false;
		if (Double.doubleToLongBits(balanceAsOn10) != Double.doubleToLongBits(other.balanceAsOn10))
			return false;
		if (Double.doubleToLongBits(balanceAsOn15) != Double.doubleToLongBits(other.balanceAsOn15))
			return false;
		if (Double.doubleToLongBits(balanceAsOn20) != Double.doubleToLongBits(other.balanceAsOn20))
			return false;
		if (Double.doubleToLongBits(balanceAsOn25) != Double.doubleToLongBits(other.balanceAsOn25))
			return false;
		if (Double.doubleToLongBits(balanceAsOn30) != Double.doubleToLongBits(other.balanceAsOn30))
			return false;
		if (Double.doubleToLongBits(balanceAsOn5) != Double.doubleToLongBits(other.balanceAsOn5))
			return false;
		if (Double.doubleToLongBits(ccInterestDebit) != Double.doubleToLongBits(other.ccInterestDebit))
			return false;
		if (inwardChqBounces != other.inwardChqBounces)
			return false;
		if (inwardChqBouncesPercentage != other.inwardChqBouncesPercentage)
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (Double.doubleToLongBits(monthlyAverage) != Double.doubleToLongBits(other.monthlyAverage))
			return false;
		if (Double.doubleToLongBits(monthlyCredits) != Double.doubleToLongBits(other.monthlyCredits))
			return false;
		if (Double.doubleToLongBits(monthlyDebits) != Double.doubleToLongBits(other.monthlyDebits))
			return false;
		if (noOfMonthlyCredits != other.noOfMonthlyCredits)
			return false;
		if (noOfMonthlyDebits != other.noOfMonthlyDebits)
			return false;
		if (outwardChqBounces != other.outwardChqBounces)
			return false;
		if (outwardChqBouncesPercentage != other.outwardChqBouncesPercentage)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
