package com.hotfoot.rapid.ai.document.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class BankStatementController {
	

	@GetMapping(value="rest/bank/statement/upload")
	private String UploadBankStatement() {
		return null;
	}
}
