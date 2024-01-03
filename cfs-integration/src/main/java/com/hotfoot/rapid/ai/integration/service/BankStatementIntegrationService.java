package com.hotfoot.rapid.ai.integration.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotfoot.rapid.ai.integration.datamodel.BankStatementDetails;
import com.hotfoot.rapid.ai.integration.datamodel.BsaCreditMonthlyCreditsDetails;
import com.hotfoot.rapid.ai.integration.datamodel.BsaDailyTransactionDetails;
import com.hotfoot.rapid.ai.integration.datamodel.BsaIntegrationStatus;
import com.hotfoot.rapid.ai.integration.datamodel.BsaIntgerationDetails;
import com.hotfoot.rapid.ai.integration.datamodel.MonthlyTransactionLineItem;
import com.hotfoot.rapid.ai.integration.model.BankDataDetails;
import com.hotfoot.rapid.ai.integration.model.BankStatementResponse;
import com.hotfoot.rapid.ai.integration.model.BsaCreditData;
import com.hotfoot.rapid.ai.integration.model.CamAnalysisData;
import com.hotfoot.rapid.ai.integration.model.CamAnalysisMonthly;
import com.hotfoot.rapid.ai.integration.model.CartRequest;
import com.hotfoot.rapid.ai.integration.model.CartResponse;
import com.hotfoot.rapid.ai.integration.model.CartUploadRequest;
import com.hotfoot.rapid.ai.integration.model.MonthlyCreditsDetails;
import com.hotfoot.rapid.ai.integration.model.ResponseToEsb;
import com.hotfoot.rapid.ai.integration.model.Transaction;
import com.hotfoot.rapid.ai.integration.repository.BsaIntegrationDetailsRepository;
import com.hotfoot.rapid.ai.integration.repository.BsaIntegrationStatusRepository;

@Component
@Service
public class BankStatementIntegrationService {
	
	@Autowired
	private BsaIntegrationDetailsRepository bsaIntegrationDetailsRepository;
	@Autowired 
	private BsaIntegrationStatusRepository bsaIntegrationStatusRepository;
	
	@Autowired
	private AsyncCartService asyncCartService;
	
	@Autowired
	private IntegrationTrack integrationTrack;
	
	@Value("${req.prefix}")
	private String prefix;
	
	@Value("${cart.stub}")
	private boolean cartStubEnabled;
	
	
	
	public static final Logger logger=LoggerFactory.getLogger(BankStatementIntegrationService.class);
	
	
	public String uploadBankStatementService(String loanId, String customerRefNo, MultipartFile bankStatement, String productName) {
		String requestId = prefix + System.currentTimeMillis() + loanId;
		BsaIntgerationDetails bsaIntegrationRequest = new BsaIntgerationDetails();
		bsaIntegrationRequest.setOperation("UPLOAD");
		bsaIntegrationRequest.setCustomerReferenceNo(customerRefNo);
		bsaIntegrationRequest.setLoanId(loanId);
		bsaIntegrationRequest.setRequestId(requestId);
		bsaIntegrationRequest.setProductName(productName);
		String requestContent = createFileUploadRequestToEsb(requestId, bankStatement);
		bsaIntegrationRequest.setRequest(requestContent);
		bsaIntegrationDetailsRepository.save(bsaIntegrationRequest);
		integrationTrack.saveRequest( productName, "BSA_UPLOAD", requestId);
		logger.info("initiating uploading bank statement request for request id {}", requestId);
		asyncCartService.uploadBankStatementService(requestId);
		return requestId;
	}
	
	private String createFileUploadRequestToEsb(String requestId, MultipartFile bsaStatementFile) {
		logger.info("creating request for uploading bank statement");
		String jsonRequest = "";
		try {
			String fileName = bsaStatementFile.getOriginalFilename();
			byte[] fileBytes = bsaStatementFile.getBytes();
			byte[] encodedBytes = Base64.getEncoder().encode(fileBytes);
			String encodedString = new String(encodedBytes);
			ObjectMapper mapper = new ObjectMapper();

			CartRequest cartRequest = new CartRequest();
			cartRequest.setFileName(fileName);
			cartRequest.setRequestId(requestId);
			cartRequest.setSource(prefix);
			cartRequest.setFileContent(encodedString);
			jsonRequest = mapper.writeValueAsString(cartRequest);
			logger.debug("uploading bank statement request" + jsonRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonRequest;
	}


	
	public List<BankStatementDetails> getBankStatementReport(String loanId,String customerRefNo, String documentId, String requestId) {
		List<BsaIntgerationDetails> bsaIntgerationDetails = bsaIntegrationDetailsRepository.findByRequestIdAndDocumentId(requestId, documentId);
		logger.info("cart request size" + bsaIntgerationDetails.size());
		integrationTrack.saveRequest("CFS", "BSA_REPORT", requestId);
		ObjectMapper mapper = new ObjectMapper();
		if (bsaIntgerationDetails.isEmpty()) {
			return null;
		} else {
			List<BankStatementDetails> bankStatements = new ArrayList<BankStatementDetails>();
			BsaIntgerationDetails maxCartObj = Collections.max(bsaIntgerationDetails, Comparator.comparing(BsaIntgerationDetails::getCreatedAt));
			logger.info("Cart Request-->" + maxCartObj);
			if (maxCartObj != null) {
				try {
					BsaIntegrationStatus cartStatus = bsaIntegrationStatusRepository.findByRequestIdAndCustomerId(requestId,customerRefNo);
					if (cartStatus == null && cartStubEnabled) {
						cartStatus = bsaIntegrationStatusRepository.findByDocumentId("DOC07811816");
					}
					logger.info("cart status for bank statement" + cartStatus);
					if (cartStatus != null && cartStatus.getStatus().equalsIgnoreCase("true")) {
						BankStatementDetails bankStatement = new BankStatementDetails();
						String newStringResponse = cartStatus.getStatementReport().replace("\\", "/");
						newStringResponse = newStringResponse.replaceAll("\n", "");
						BankStatementResponse statementResponse = mapper.readValue(newStringResponse, BankStatementResponse.class);
						logger.debug("response" + statementResponse);
						if (statementResponse.getStatus().equalsIgnoreCase("Processed")) {
							List<BankDataDetails> bankData = statementResponse.getData();
							if (!bankData.isEmpty()) {
								for (BankDataDetails datum : bankData) {									
									bankStatement.setLoanId(loanId);
									bankStatement.setCustomerReferenceNo(customerRefNo);
									bankStatement.setDocumentId(documentId);
									bankStatement.setAccountHolderName(datum.getAccountName());
									bankStatement.setAcNumber(datum.getAccountNumber());
									bankStatement.setAcType(datum.getAccountType());
									bankStatement.setBankName(datum.getBankName());
									bankStatement.setSource('C');
									bankStatement.setUniqueId(UUID.randomUUID().toString());

									CamAnalysisData camAnalysisData = datum.getCamAnalysisData();
									List<MonthlyTransactionLineItem> monthlyTransactionLineItemList = new ArrayList<MonthlyTransactionLineItem>();
									List<CamAnalysisMonthly> monthlyDetails = camAnalysisData.getCamAnalysisMonthly();
									for (CamAnalysisMonthly camAnalysisMonthly : monthlyDetails) {
										if (camAnalysisMonthly.getMonth().equalsIgnoreCase("Grand Total")) {
											bankStatement.setTotalInwardChqBounces(camAnalysisMonthly.getNoOfInwardReturn());
//										 bankStatement.setTotalInwardChqBouncesPercentage(0);
											bankStatement.setTotalMonthlyAverage(camAnalysisData.getCustomAverageBalance());
											bankStatement.setTotalMonthlyCredits(camAnalysisMonthly.getNetCreditAmount());
											bankStatement.setTotalMonthlyDebits(camAnalysisMonthly.getNetDebitAmount());
											bankStatement.setTotalNoOfMonthlyCredits(camAnalysisMonthly.getNoOfCredit());
											bankStatement.setTotalNoOfMonthlyDebits(camAnalysisMonthly.getNoOfDebit());
											bankStatement.setAbb(camAnalysisMonthly.getMonthlyAvgInclOdCcLimit());
											bankStatement.setTotalOutwardChqBounces(camAnalysisMonthly.getNoOfOutwardReturn());
//										bankStatement.setTotalOutwardChqBouncesPercentage(camAnalysisMonthly);

										} else {
											MonthlyTransactionLineItem lineItem = new MonthlyTransactionLineItem();
											String[] data = camAnalysisMonthly.getMonth().split("-");
											lineItem.setMonth(data[0]);
											lineItem.setYear(Integer.parseInt(data[1]));
											lineItem.setNoOfMonthlyCredits(camAnalysisMonthly.getNoOfCredit());
											lineItem.setNoOfMonthlyDebits(camAnalysisMonthly.getNoOfDebit());
											lineItem.setMonthlyCredits(camAnalysisMonthly.getNetCreditAmount());
											lineItem.setMonthlyDebits(camAnalysisMonthly.getNetDebitAmount());
											lineItem.setInwardChqBounces(camAnalysisMonthly.getNoOfInwardReturn());
											lineItem.setOutwardChqBounces(camAnalysisMonthly.getNoOfOutwardReturn());
											lineItem.setAbb(camAnalysisMonthly.getMonthlyAvgInclOdCcLimit());
											if (camAnalysisMonthly.getCustomDayBalances() != null) {
//											 lineItem.setBalanceAsOn1(balanceAsOn1);
//											 lineItem.setBalanceAsOn10();
												lineItem.setBalanceAsOn15(camAnalysisMonthly.getCustomDayBalances().getBalon15());
//											 lineItem.setBalanceAsOn20(balanceAsOn20);
												lineItem.setBalanceAsOn25(camAnalysisMonthly.getCustomDayBalances().getBalOn25());
												lineItem.setBalanceAsOn5(camAnalysisMonthly.getCustomDayBalances().getBalOn5());
											}
											monthlyTransactionLineItemList.add(lineItem);
										}
									}

									// To process bsa credit: monthly credit details
									BsaCreditData bsaCreditData = datum.getBsaCreditData();
									List<BsaCreditMonthlyCreditsDetails> bsaCreditsMonthlyList = new ArrayList<>();
									List<MonthlyCreditsDetails> monthlyCreditsDetails = bsaCreditData.getMonthlyCreditsDetails();
									if (bsaCreditData != null && monthlyCreditsDetails != null && !monthlyCreditsDetails.isEmpty()) {
										for (MonthlyCreditsDetails monthlyCreditsDetail : monthlyCreditsDetails) {
											BsaCreditMonthlyCreditsDetails bsaCreditMonthlyCreditsDetails = new BsaCreditMonthlyCreditsDetails();
											String monthYear[] = monthlyCreditsDetail.getMonthYear().split("-");
											bsaCreditMonthlyCreditsDetails.setMonth(monthYear[0]);
											bsaCreditMonthlyCreditsDetails.setYear(Integer.parseInt(monthYear[1]));
											bsaCreditMonthlyCreditsDetails.setCredit(monthlyCreditsDetail.getCredit());
											bsaCreditMonthlyCreditsDetails.setSalaryCredit(monthlyCreditsDetail.getSalaryCredit());
											bsaCreditsMonthlyList.add(bsaCreditMonthlyCreditsDetails);
										}
									}

									bankStatement.setTransactions(monthlyTransactionLineItemList);
									bankStatement.setBsaCreditMonthlyCreditsDetails(bsaCreditsMonthlyList);
									
									//to process daily transactio details
									List<Transaction> transactions = datum.getTransactions();
									List<BsaDailyTransactionDetails> listOfdailytransactionDetails = new ArrayList<BsaDailyTransactionDetails>();
									if(transactions != null && !transactions.isEmpty()) {
										for(Transaction  transaction: transactions) {
											BsaDailyTransactionDetails dailyTransactionDetails = new BsaDailyTransactionDetails();
											dailyTransactionDetails.setBalanceAfterTransaction(transaction.getClosingBalance());
											dailyTransactionDetails.setBalanceBeforeTransaction(transaction.getOpeningBalance());
											dailyTransactionDetails.setModeOfPayment(transaction.getPaymentMode());
											dailyTransactionDetails.setIgnorableTransaction(transaction.getIgnorableTransaction());
											dailyTransactionDetails.setMonthAndYear(transaction.getMonthYear());
											dailyTransactionDetails.setCheque(transaction.getCheque());
											dailyTransactionDetails.setNameOfReceiver(transaction.getName());
											dailyTransactionDetails.setPaymentCategory(transaction.getPaymentCategory());
											dailyTransactionDetails.setPaymentNarration(transaction.getNarration());
											dailyTransactionDetails.setTransactionAmount(transaction.getAmount());
											dailyTransactionDetails.setTransactionDate(transaction.getTransactionDate());
											dailyTransactionDetails.setTransactionType(transaction.getType());
											dailyTransactionDetails.setHoliday(transaction.getHoliday());
											listOfdailytransactionDetails.add(dailyTransactionDetails);
										}
									}
									bankStatement.setBsaDailyTransactionDetails(listOfdailytransactionDetails);			
									
								}
							}
							bankStatements.add(bankStatement);
						} else if (statementResponse.getStatus().equalsIgnoreCase("Rejected")) {

						} else {
							throw new RuntimeException(statementResponse.getMessage());
						}
					}
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return bankStatements;
		}
	}
	
	public CartResponse uploadFileStatus(String requestId) {
		try {
			BsaIntgerationDetails cartRequestModel = bsaIntegrationDetailsRepository.findByRequestId(requestId);
			logger.info("bank statement response from DB {} ", cartRequestModel);
			if (cartRequestModel.getResponse() == null) {
				return null;
			} else {
				ObjectMapper mapper = new ObjectMapper();
				CartResponse cartResponse = mapper.readValue(cartRequestModel.getResponse(), CartResponse.class);
				return cartResponse;
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResponseEntity<?> uploadStatus(CartUploadRequest cartUploadRequest, String productName) {
		logger.info("cart status from ESB for document id" + cartUploadRequest.getDocumentId());
		integrationTrack.saveRequest(productName, "BSA_STATUS", cartUploadRequest.getRequestid());
		BsaIntgerationDetails cartRequest = bsaIntegrationDetailsRepository.findByLoanIdAndCustomerReferenceNoAndRequestId(cartUploadRequest.getLoanId(),
				cartUploadRequest.getCustomerRef(), cartUploadRequest.getRequestid());
		if (cartRequest == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Document id not found...");
		} else {
			BsaIntegrationStatus cartUploadStatusModel = new BsaIntegrationStatus();
			cartUploadStatusModel.setDocumentId(cartUploadRequest.getDocumentId());
			cartUploadStatusModel.setRequestId(cartUploadRequest.getRequestid());
			cartUploadStatusModel.setStatus(cartUploadRequest.getStatus());
			cartUploadStatusModel.setStatementReport(cartUploadRequest.getBankstatementReport());
			cartUploadStatusModel.setProductName(productName);
			bsaIntegrationStatusRepository.save(cartUploadStatusModel);
			ResponseToEsb successResponse = new ResponseToEsb();
			successResponse.setStatus("Success");
			return ResponseEntity.ok(successResponse);
		}
	}
	

}
