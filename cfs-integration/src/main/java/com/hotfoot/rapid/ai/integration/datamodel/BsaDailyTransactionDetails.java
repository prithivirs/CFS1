package com.hotfoot.rapid.ai.integration.datamodel;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name="daily_transaction_details")
@Data
public class BsaDailyTransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id ;
	
	
	@JsonProperty("transactionDate")
	@Column(name = "transaction_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date transactionDate;
	
	@JsonProperty("narration")
	@Column(name = "payment_narration")
	private String paymentNarration;
	
	@JsonProperty("paymentMode")
	@Column(name = "mode_of_payment")
	private String modeOfPayment;
	
	@JsonProperty("paymentCategory")
	@Column(name = "payment_category")
	private String paymentCategory;
	
	@JsonProperty("cheque")
	@Column(name = "cheque")
	private String cheque;
	
	@JsonProperty("amount")
	@Column(name = "transaction_amount")
	private Double transactionAmount;
	
	@JsonProperty("type")
	@Column(name = "transaction_type")
	private String transactionType;
	
	@JsonProperty("openingBalance")
	@Column(name = "opening_balance")
	private Double balanceBeforeTransaction;
	
	@JsonProperty("closingBalance")
	@Column(name = "closing_balance")
	private Double balanceAfterTransaction;

	@JsonProperty("monthYear")
	@Column(name = "month_and_year")
	private String monthAndYear;
	
	@JsonProperty("name")
	@Column(name = "recceiver_name")
	private String nameOfReceiver;
	
	@JsonProperty("ignorableTransaction")
	@Column(name = "ignorable_transaction")
	private Boolean ignorableTransaction;
	
	@JsonProperty("holiday")
	@Column(name = "holiday")
	private Boolean holiday;
}
