package com.hotfoot.rapid.ai.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.document.service.ScoreCalCulationService;

@RestController
public class ScoreCalculationController {
	
	@Autowired
	private ScoreCalCulationService scoreCalCulationService;
	
	@GetMapping(value = "/rest/get/customer/{customer_id}/score")
	public String getScore(@PathVariable("customer_id") String customerId) {
		return scoreCalCulationService.getScore(customerId);

	}
}
