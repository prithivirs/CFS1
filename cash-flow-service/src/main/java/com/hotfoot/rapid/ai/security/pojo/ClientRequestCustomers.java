package com.hotfoot.rapid.ai.security.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientRequestCustomers {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("middle_name")
	private String middleName;

	@JsonProperty("customer_id")
	private String customeId;

	@JsonProperty("customer_category")
	private String customerCategory;

	@JsonProperty("customer_type")
	private String customerType;

	@JsonProperty("date_of_birth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	@JsonProperty("gender")
	private String gender;

}
