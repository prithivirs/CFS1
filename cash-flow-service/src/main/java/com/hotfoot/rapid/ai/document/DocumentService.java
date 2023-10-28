package com.hotfoot.rapid.ai.document;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class DocumentService {
	
	
	public String getCashFlowScore(String customerId) {
		return ("hi , your score is 3.12");
	}

}
