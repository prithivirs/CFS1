package com.hotfoot.rapid.ai.integration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hotfoot.rapid.ai.integration.datamodel.BankStatementDetails;
import com.hotfoot.rapid.ai.integration.model.CartResponse;
import com.hotfoot.rapid.ai.integration.model.CartUploadRequest;
import com.hotfoot.rapid.ai.integration.service.BankStatementIntegrationService;

@RestController
public class BankStatementIntegrationController {

	@Autowired
	private BankStatementIntegrationService bankStatementIntegrationService;

	public static final Logger logger = LoggerFactory.getLogger(BankStatementIntegrationController.class);

	// upload bank statement
	@RequestMapping(value = "/rest/cart/upload", method = RequestMethod.POST)
	public String uploadBankStatementService(HttpServletRequest httpRequest, @RequestParam("application_ref_no") String applicationRefNo,
			@RequestParam("customer_ref_no") String customerRefNo, @RequestParam("file") MultipartFile bankStatement) {
		logger.info("uploading bank statement for application id {} and customer reference number {}", applicationRefNo, customerRefNo);
		return bankStatementIntegrationService.uploadBankStatementService(applicationRefNo, customerRefNo, bankStatement,"");
	}

	// get upload bank statement response based on requestId
	@RequestMapping(value = "/upload/status", method = RequestMethod.GET)
	public ResponseEntity<?> uploadFileStatus(HttpServletRequest httpRequest, @RequestParam("request_id") String requestId) {
		logger.info("get uploaded bank statement response for request id {} ", requestId);
		CartResponse cartResponse = bankStatementIntegrationService.uploadFileStatus(requestId);
		logger.info("uploaded bank statement response {} ", cartResponse);
		if (cartResponse == null) {
			return ResponseEntity.ok("Processing Request");
		}
		return ResponseEntity.ok(cartResponse);
	}

	// call back url
	@RequestMapping(value = "file_status", method = RequestMethod.POST)
	public ResponseEntity<?> uploadStatus(HttpServletRequest httpRequest, @RequestBody CartUploadRequest cartUploadRequest) {
			return bankStatementIntegrationService.uploadStatus(cartUploadRequest, "");

	}

	// bank statement report
	@RequestMapping(value = "/rest/cart/statement_report", method = RequestMethod.GET)
	public ResponseEntity<?> getBankStatementReport(HttpServletRequest httpRequest, @RequestParam("application_ref_no") String applicationRefNo,
			@RequestParam("document_id") String documentId, @RequestParam("request_id") String requestId) {
		logger.info("bank statement response for application id {} and documentId {} and requestId {} ", applicationRefNo, documentId, requestId);
		List<BankStatementDetails> bankStatements = bankStatementIntegrationService.getBankStatementReport(applicationRefNo, documentId, requestId);
		logger.info("bank statement response {}", bankStatements);
		if (bankStatements.isEmpty()) {
			return ResponseEntity.ok("Processing Request");
		}
		return ResponseEntity.ok(bankStatements);

	}


}
