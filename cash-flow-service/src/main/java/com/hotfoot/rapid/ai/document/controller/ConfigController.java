package com.hotfoot.rapid.ai.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.document.service.ConfigService;

@RestController
public class ConfigController {
	
	@Autowired
	private ConfigService configService;
	
	@GetMapping(value = "/rest/check/status")
	public boolean getScore(@RequestParam("service_type") String serviceType) {
		return configService.checkStatus(serviceType);

	}

}
