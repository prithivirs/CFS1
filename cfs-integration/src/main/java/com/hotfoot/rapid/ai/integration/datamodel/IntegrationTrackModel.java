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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "integration_record")
public class IntegrationTrackModel implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053815656680287754L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="type")
	private String type;
	
	@Column(name="application_ref_no")
	private String applicationReferenceNo;
	
	@Column(name="integration_id")
	private String integrationId;
	
	@Column(name="created_date")
	private Date createdDate=new Date();
}
