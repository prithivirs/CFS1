package com.hotfoot.rapid.ai.integration.service;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotfoot.rapid.ai.integration.datamodel.BsaIntgerationDetails;
import com.hotfoot.rapid.ai.integration.model.CartRequest;
import com.hotfoot.rapid.ai.integration.model.CartResponse;
import com.hotfoot.rapid.ai.integration.repository.BsaIntegrationDetailsRepository;

@Component
public class AsyncCartService {
	
public static final Logger logger=LoggerFactory.getLogger(AsyncCartService.class);
	
	@Autowired
	BsaIntegrationDetailsRepository bsaIntegrationRepository;
	
	@Value("${esb.url}")
	private String url;
	
	@Autowired
	private RestTemplate template;
	
	@Async
	public void uploadBankStatementService(String requestId) {
		BsaIntgerationDetails cartRequestModel = bsaIntegrationRepository.findByRequestId(requestId);
		if(cartRequestModel!=null) {
			try {
				ObjectMapper mapper=new ObjectMapper();
				CartRequest cartRequest=mapper.readValue(cartRequestModel.getRequest(), CartRequest.class);
				String cartUploadUrl=url+"CartService/upload";
				logger.info("uploading bank statement service url {} ", cartUploadUrl);
				HttpEntity<CartRequest> entity=new HttpEntity<CartRequest>(cartRequest);
				logger.info("upload statement client request {} ",mapper.writeValueAsString(entity));
				ResponseEntity<String> httpResponse = template.postForEntity(cartUploadUrl, entity, String.class);
				logger.info("upload statement response"+ httpResponse.getBody());
				if(httpResponse.getStatusCode().value()==200) {
					CartResponse cartResponse=mapper.readValue(httpResponse.getBody(), CartResponse.class);
					cartRequestModel.setDocumentId(cartResponse.getDocumentId());
					cartRequestModel.setStatus(1);
					cartRequestModel.setResponse(httpResponse.getBody());
				}else {
					cartRequestModel.setStatus(0);
					cartRequestModel.setResponse(httpResponse.getBody());
				}
				cartRequestModel.setResponseDate(new Date());
				cartRequestModel=bsaIntegrationRepository.save(cartRequestModel);
			} catch (IOException e) {
				logger.error("error in calling api {} ", e);
				e.printStackTrace();
				cartRequestModel.setResponseDate(new Date());
				cartRequestModel.setStatus(0);
				cartRequestModel.setResponse(e.getMessage());
				bsaIntegrationRepository.save(cartRequestModel);
			} 
		}
		
	}
	

}
