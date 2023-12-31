package com.hotfoot.rapid.ai.integration.datamodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class BankStatementDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "unique_id")
	@JsonProperty("unique_id")
	private String uniqueId;

	@Column(name = "application_reference_no")
	@JsonProperty("application_reference_no")
	private String applicationReferenceNo;

	@Column(name = "customer_reference_no")
	@JsonProperty("customer_reference_no")
	private String customerReferenceNo;

	@Column(name = "customer_role")
	@JsonProperty("customer_role")
	private String customerRole;

	@Column(name = "source")
	@JsonProperty("source")
	private Character source;

	@Column(name = "consider_for_eligibility")
	@JsonProperty("consider_for_eligibility")
	private Character considerForEligibility;

	@Column(name = "account_holder_name")
	@JsonProperty("account_holder_name")
	private String accountHolderName;

	@Column(name = "bank_name")
	@JsonProperty("bank_name")
	private String bankName;

	@Column(name = "branch_name")
	@JsonProperty("branch_name")
	private String branchName;

	@Column(name = "ac_type")
	@JsonProperty("ac_type")
	private String acType;

	@Column(name = "ac_number")
	@JsonProperty("ac_number")
	private String acNumber;

	@Column(name = "ifsc_code")
	@JsonProperty("ifsc_code")
	private String ifscCode;

	@Column(name = "is_verified")
	@JsonProperty("is_verified")
	private Boolean isVerified;

	@Column(name = "abb")
	@JsonProperty("abb")
	private Double abb;

	@Column(name = "total_monthly_credits")
	@JsonProperty("total_monthly_credits")
	private Double totalMonthlyCredits;

	@Column(name = "total_monthly_debits")
	@JsonProperty("total_monthly_debits")
	private Double totalMonthlyDebits;

	@Column(name = "total_monthly_average")
	@JsonProperty("total_monthly_average")
	private Double totalMonthlyAverage;

	@Column(name = "total_no_of_monthly_debits")
	@JsonProperty("total_no_of_monthly_debits")
	private Integer totalNoOfMonthlyDebits;

	@Column(name = "total_no_of_monthly_credits")
	@JsonProperty("total_no_of_monthly_credits")
	private Integer totalNoOfMonthlyCredits;

	@Column(name = "total_inward_chq_bounces")
	@JsonProperty("total_inward_chq_bounces")
	private Integer totalInwardChqBounces;

	@Column(name = "total_outward_chq_bounces")
	@JsonProperty("total_outward_chq_bounces")
	private Integer totalOutwardChqBounces;

	@Column(name = "total_inward_chq_bounces_percentage")
	@JsonProperty("total_inward_chq_bounces_percentage")
	private Double totalInwardChqBouncesPercentage;

	@Column(name = "total_outward_chq_bounces_percentage")
	@JsonProperty("total_outward_chq_bounces_percentage")
	private Double totalOutwardChqBouncesPercentage;

	@Column(name = "banking_stability")
	@JsonProperty("banking_stability")
	private String bankingStability;

	@Column(name = "no_of_emi_cheque_bounces_for_last_6_months")
	@JsonProperty("no_of_emi_cheque_bounces_for_last_6_months")
	private String noOfEmiChequeBouncesForLast6Months;

	@Column(name = "percentage_of_inward_return_for_last_6_months")
	@JsonProperty("percentage_of_inward_return_for_last_6_months")
	private String percentageOfInwardReturnForLast6Months;

	@Column(name = "monthly_summary")
	@JsonProperty("monthly_summary")
	private String monthlySummary;

	@ElementCollection(targetClass = MonthlyTransactionLineItem.class)
	@CollectionTable(name = "bank_stmt_monthly_transaction_li", joinColumns = @JoinColumn(name = "bank_stmt_id", referencedColumnName = "id"))
	@JsonProperty("transactions")
	private List<MonthlyTransactionLineItem> transactions;

	private final String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	@Column(name = "repayment_account")
	@JsonProperty("repayment_account")
	private String repaymentAccount;

	@Column(name = "beneficiary_account")
	@JsonProperty("beneficiary_account")
	private String beneficiaryTccount;

	@Column(name = "statement_available")
	@JsonProperty("statement_available")
	private String statementAvailable;

	@Column(name = "emi_bounces_in_last_3_months")
	@JsonProperty("emi_bounces_in_last_3_months")
	private Integer emiBouncesInLast3Months;

	@Column(name = "emi_bounces_in_last_6_months")
	@JsonProperty("emi_bounces_in_last_6_months")
	private Integer emiBouncesInLast6Months;

	@Column(name = "pct_of_inw_return_3_months")
	@JsonProperty("pct_of_inw_return_3_months")
	private Double percentageOfInwardReturnIn3Months;

	@Column(name = "pct_of_inw_return_6_months")
	@JsonProperty("pct_of_inw_return_6_months")
	private Double percentageOfInwardReturnIn6Months;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "bankstatement_id")
	private List<BsaCreditMonthlyCreditsDetails> bsaCreditMonthlyCreditsDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "bankstatement_id")
	private List<BsaDailyTransactionDetails> bsaDailyTransactionDetails;

}
