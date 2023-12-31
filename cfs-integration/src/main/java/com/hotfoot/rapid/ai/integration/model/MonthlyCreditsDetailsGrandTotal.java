package com.hotfoot.rapid.ai.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonthlyCreditsDetailsGrandTotal {
	@Override
	public String toString() {
		return "MonthlyCreditsDetailsGrandTotal [monthYear=" + monthYear + ", credit=" + credit + ", salaryCredit=" + salaryCredit + "]";
	}

	@JsonProperty("Month-Year")
	String monthYear;

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	@JsonProperty("Credit")
	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	double credit;

	@JsonProperty("Salary Credit")
	double salaryCredit;

	public double getSalaryCredit() {
		return salaryCredit;
	}

	public void setSalaryCredit(double salaryCredit) {
		this.salaryCredit = salaryCredit;
	}
}
