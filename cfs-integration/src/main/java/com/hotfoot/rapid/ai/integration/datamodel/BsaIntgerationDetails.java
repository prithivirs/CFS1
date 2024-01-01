package com.hotfoot.rapid.ai.integration.datamodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
@Table(name="bsa_upload")
public class BsaIntgerationDetails implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5365720602564473702L;

	public BsaIntgerationDetails() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="request_id")
	private String requestId;
	
	@Column(name="loan_id")
	private String loanId;
	
	@Column(name="customer_reference_no")
	private String customerReferenceNo;
	
	@Column(name="operation")
	private String operation;
	
	@Lob
	@Column(name="request")
	private String request;
	
	@Lob
	@Column(name="response")
	private String response;
	
	@Column(name="status")
	private int status;
	
	@Column(name="document_id")
	private String documentId;
	
	@Column(name="create_date")
	private Date createdAt=new Date();
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="response_date")
	private Date responseDate;

}
