package com.hotfoot.rapid.ai.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.document.service.BankStatementService;

@Component
@RestController
public class BankStatementController {
	
	@Autowired
	private BankStatementService bankStatementService;

	@GetMapping(value="rest/bank/statement/upload")
	private String UploadBankStatement() {
		return null;
	}
	
	@GetMapping(value="rest/analyze/pdf")
	private ResponseEntity<String> analyzePdf(@RequestParam("pdf_name")String pdfName) {
		return bankStatementService.validatePdf(pdfName);
	}
	
}
