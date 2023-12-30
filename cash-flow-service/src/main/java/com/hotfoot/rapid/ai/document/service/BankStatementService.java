package com.hotfoot.rapid.ai.document.service;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BankStatementService {
	
	@Value("${document.upload_file_path}")
	private String uploadPath;

	public ResponseEntity<String> validatePdf(String pdfName) {
		try {
			File pdfFile = new File(uploadPath + pdfName);
			PDDocument document = PDDocument.load(pdfFile);
			PDFTextStripper pdfTextStripper = new PDFTextStripper();
			// Get text content from the PDF
			String pdfText = pdfTextStripper.getText(document);
			if (pdfText.trim().length() < 30) {
				document.close();
				return ResponseEntity.status(HttpStatus.OK)
						.body("PDF is Scanned and might take longer time to analyze");
			} else {
				document.close();
				return ResponseEntity.status(HttpStatus.OK).body("PDF analysis in progress");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to identify authenticity of pdf");
	}

}
