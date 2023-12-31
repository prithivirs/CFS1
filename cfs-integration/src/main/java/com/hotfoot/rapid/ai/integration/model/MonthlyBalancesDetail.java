package com.hotfoot.rapid.ai.integration.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthlyBalancesDetail {

	@JsonProperty("averageBalanceOn1st")
	public double getAverageBalanceOn1st() {
		return this.averageBalanceOn1st;
	}

	public void setAverageBalanceOn1st(double averageBalanceOn1st) {
		this.averageBalanceOn1st = averageBalanceOn1st;
	}

	double averageBalanceOn1st;

	@JsonProperty("averageBalanceOn5th")
	public double getAverageBalanceOn5th() {
		return this.averageBalanceOn5th;
	}

	public void setAverageBalanceOn5th(double averageBalanceOn5th) {
		this.averageBalanceOn5th = averageBalanceOn5th;
	}

	double averageBalanceOn5th;

	@JsonProperty("averageBalanceOn10th")
	public double getAverageBalanceOn10th() {
		return this.averageBalanceOn10th;
	}

	public void setAverageBalanceOn10th(double averageBalanceOn10th) {
		this.averageBalanceOn10th = averageBalanceOn10th;
	}

	double averageBalanceOn10th;

	@JsonProperty("averageBalanceOn15th")
	public double getAverageBalanceOn15th() {
		return this.averageBalanceOn15th;
	}

	public void setAverageBalanceOn15th(double averageBalanceOn15th) {
		this.averageBalanceOn15th = averageBalanceOn15th;
	}

	double averageBalanceOn15th;

	@JsonProperty("averageBalanceOn20th")
	public double getAverageBalanceOn20th() {
		return this.averageBalanceOn20th;
	}

	public void setAverageBalanceOn20th(double averageBalanceOn20th) {
		this.averageBalanceOn20th = averageBalanceOn20th;
	}

	double averageBalanceOn20th;

	@JsonProperty("averageBalanceOn25th")
	public double getAverageBalanceOn25th() {
		return this.averageBalanceOn25th;
	}

	public void setAverageBalanceOn25th(double averageBalanceOn25th) {
		this.averageBalanceOn25th = averageBalanceOn25th;
	}

	double averageBalanceOn25th;
	
	@JsonProperty("Month-Year") 
    String monthYear;

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	@JsonProperty("AMB")
	public double getAMB() {
		return this.aMB;
	}

	public void setAMB(double aMB) {
		this.aMB = aMB;
	}

	double aMB;
	
	@JsonProperty("Average of Custom Day")
	double averageOfCustomDay;

	@Override
	public String toString() {
		return "MonthlyBalancesDetail [averageBalanceOn1st=" + averageBalanceOn1st + ", averageBalanceOn5th=" + averageBalanceOn5th + ", averageBalanceOn10th="
				+ averageBalanceOn10th + ", averageBalanceOn15th=" + averageBalanceOn15th + ", averageBalanceOn20th=" + averageBalanceOn20th + ", averageBalanceOn25th="
				+ averageBalanceOn25th + ", monthYear=" + monthYear + ", aMB=" + aMB + ", averageOfCustomDay=" + averageOfCustomDay + "]";
	}

	public double getAverageOfCustomDay() {
		return averageOfCustomDay;
	}

	public void setAverageOfCustomDay(double averageOfCustomDay) {
		this.averageOfCustomDay = averageOfCustomDay;
	}


}
