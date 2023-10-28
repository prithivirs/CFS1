package com.hotfoot.rapid.ai.cfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = { "com.hotfoot" })
@EntityScan(basePackages = { "com.hotfoot" })
@EnableJpaRepositories(basePackages = { "com.hotfoot" })
@RestController
public class CFSBootService {
	
	@GetMapping("/getScore")
	public String getCashFlowScore() {
		return ("hi , your score is 3.12");
	}

	public static void main(String[] args) {
		SpringApplication.run(CFSBootService.class, args);
	}
}
