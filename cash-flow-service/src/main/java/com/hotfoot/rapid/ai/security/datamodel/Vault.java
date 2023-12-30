package com.hotfoot.rapid.ai.security.datamodel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Vault {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonProperty("vendor_name")
	private String vendorName;
	
	@JsonProperty("secretKey")
	private String secretKey;

	@JsonProperty("is_active")
	private boolean isActive;
	
	@JsonProperty("created_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date createdDate;
}
