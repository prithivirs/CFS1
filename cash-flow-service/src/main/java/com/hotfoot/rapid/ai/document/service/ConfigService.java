package com.hotfoot.rapid.ai.document.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "services.status")
@Data
public class ConfigService {

	private boolean cartEnabled;

	private boolean perfiosEnabled;

	public boolean checkStatus(String serviceType) {
		switch (serviceType) {
		case "CART":
			return cartEnabled;
		case "PERFIOS":
			return perfiosEnabled;
		default:
			return false;
		}
	}

}
