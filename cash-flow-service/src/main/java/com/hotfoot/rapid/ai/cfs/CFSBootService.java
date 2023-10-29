package com.hotfoot.rapid.ai.cfs;

import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotfoot.rapid.ai.document.UploadFile;

@SpringBootApplication(scanBasePackages = { "com.hotfoot" })
@EntityScan(basePackages = { "com.hotfoot" })
@EnableJpaRepositories(basePackages = { "com.hotfoot" })
@RestController
@EnableAsync
public class CFSBootService {
	
	@GetMapping("/getScore")
	public String getCashFlowScore() {
		return ("hi , your score is 3.12");
	}

	public static void main(String[] args) {
		SpringApplication.run(CFSBootService.class, args);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean<Servlet> uploadFile(@Value("${document.upload_file_path}") String rootPath,
			@Value("#{'${document.permitted_content_types}'.split(',')}") List<String> permittedContentTypes, @Value("${aws.upload}") boolean aws,
			@Value("${document.local_upload_file_path}") String localPath) {
		final UploadFile uploadFile = new UploadFile(rootPath, permittedContentTypes, aws, localPath);
		return new ServletRegistrationBean(uploadFile, "/uploadfile");
	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public ServletRegistrationBean showFile(@Value("#{'${proofdocuments.additional_upload_path}'.split(',')}") List<String> rootPath,
//			@Value("${proofdocuments.local_upload_file_path}") String localPath, @Value("${aws.upload}") boolean aws) {
//		return new ServletRegistrationBean(new ShowFile(rootPath, localPath, aws), "/showfile");
//	}
}
