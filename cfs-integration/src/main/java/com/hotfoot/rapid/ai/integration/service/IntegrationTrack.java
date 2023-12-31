package com.hotfoot.rapid.ai.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.integration.datamodel.IntegrationTrackModel;
import com.hotfoot.rapid.ai.integration.repository.IntegrationTrackRepository;

@Component
public class IntegrationTrack {
	
	@Autowired
	IntegrationTrackRepository trackRepo;
	
	public  void saveRequest( String productName, String operation, String integrationRequestId) {
		IntegrationTrackModel trackModel=new IntegrationTrackModel();
		trackModel.setIntegrationId(integrationRequestId);
		trackModel.setProductName(productName);
		trackModel.setType(operation);
		trackRepo.save(trackModel);
	}

}
