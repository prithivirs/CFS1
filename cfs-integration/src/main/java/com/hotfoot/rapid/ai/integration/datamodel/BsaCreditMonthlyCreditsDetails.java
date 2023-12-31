package com.hotfoot.rapid.ai.integration.datamodel;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "bsacredit_monthlycredits_details")
public class BsaCreditMonthlyCreditsDetails {
	


	@Override
	public int hashCode() {
		return Objects.hash(id, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BsaCreditMonthlyCreditsDetails other = (BsaCreditMonthlyCreditsDetails) obj;
		return id == other.id && Objects.equals(month, other.month) && year == other.year;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BsaCreditMonthlyCreditsDetails [id=" + id + ", month=" + month + ", year=" + year + ", credit=" + credit + ", salaryCredit=" + salaryCredit + "]";
	}

	public void setId(long id) {
		this.id = id;
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

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getSalaryCredit() {
		return salaryCredit;
	}

	public void setSalaryCredit(double salaryCredit) {
		this.salaryCredit = salaryCredit;
	}

	@Column(name = "month")
	private String month;

	@Column(name = "year")
	private int year;

	@Column(name = "credit")
	double credit;

	@Column(name = "salary_credit")
	double salaryCredit;


}
