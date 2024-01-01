package com.hotfoot.rapid.ai.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotfoot.rapid.ai.integration.datamodel.BsaIntegrationStatus;
import com.hotfoot.rapid.ai.integration.model.AnalysisDatum;
import com.hotfoot.rapid.ai.integration.model.BankDataDetails;
import com.hotfoot.rapid.ai.integration.model.BankStatementResponse;
import com.hotfoot.rapid.ai.integration.model.CamAnalysisData;
import com.hotfoot.rapid.ai.integration.model.CamAnalysisMonthly;
import com.hotfoot.rapid.ai.integration.repository.BsaIntegrationStatusRepository;
import com.hotfoot.rapid.ai.integration.service.BankStatementIntegrationService;

@Service
public class ScoreCalCulationService {

	@Autowired
	private BankStatementIntegrationService bankStatementIntegrationService;

	@Autowired
	private BsaIntegrationStatusRepository bsaIntegrationStatusRepository;

	public String getScore(String customerId) {

		return "score is 5,1";
	}

	public String calculateScore(String customerId) throws JsonMappingException, JsonProcessingException {

		BsaIntegrationStatus cartStatus = bsaIntegrationStatusRepository.findByDocumentId("DOC07811816");
		if (cartStatus != null && cartStatus.getStatus().equalsIgnoreCase("true")) {
			String newStringResponse = cartStatus.getStatementReport().replace("\\", "/");
			newStringResponse = newStringResponse.replaceAll("\n", "");
			ObjectMapper mapper = new ObjectMapper();
			BankStatementResponse bankStatements = mapper.readValue(newStringResponse, BankStatementResponse.class);
			List<BankDataDetails> data = bankStatements.getData();
			for (BankDataDetails bsa : data) {
				int numberOfBankStatementsForCurrentYear = bsa.getNumberOfBankStatementsForYear(0);
				int numberOfBankStatementsForPreviousYear = bsa.getNumberOfBankStatementsForYear(1);
				CamAnalysisData camAnalysisData = bsa.getCamAnalysisData();
				List<CamAnalysisMonthly> camAnalysisMonthly = camAnalysisData.getCamAnalysisMonthly();
				for (CamAnalysisMonthly cam : camAnalysisMonthly) {
					String month = cam.getMonth();
					System.out.println(month);
				}
				List<AnalysisDatum> month = bsa.getAnalysisData();
				for (AnalysisDatum bankDataDetails : month) {
					if (bankDataDetails.getMonth().equalsIgnoreCase("Grand Total")) {
						System.out.println(bankDataDetails);
						double totalInterestPaid = bankDataDetails.getTotalInterestPaid();
						double totalInterestReceived = bankDataDetails.getTotalInterestReceived();
						double net_interest_12m = totalInterestReceived - totalInterestPaid;
						double total_interest_earned_12m = totalInterestReceived;
						System.out.println(net_interest_12m + "hi " + total_interest_earned_12m);
					}
				}
			}

		}
		return null;
	}

}
