package com.hotfoot.rapid.ai.integration.datamodel;

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
@Table(name="bsa_status")
@Data
public class BsaIntegrationStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="document_id")
	private String documentId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="request_id")
	private String requestId;
	
	@Lob
	@Column(name="statement_report")
	private String statementReport;
	
	@Column(name="create_date")
	private Date createDate=new Date();
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="customer_id")
	private String customerId;

}
