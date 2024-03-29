package com.hotfoot.rapid.ai.security.service;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotfoot.rapid.ai.security.datamodel.Vault;
import com.hotfoot.rapid.ai.security.repository.VaultRepository;

@Component
public class SecretTokenProviderService {
	
	@Autowired
	private VaultRepository tokenRepo;

    public String generateSecretKey(String client) {
        // Generate a secure random byte array
        byte[] randomBytes = generateRandomBytes(32); // Adjust the size of the byte array as needed

        // Convert the byte array to a Base64-encoded string
        Vault vault = tokenRepo.findByVendorNameAndIsActive(client,true);
        String encodedValue = base64Encode(randomBytes);
		if(vault == null) {
        	vault = new Vault();
        	vault.setSecretKey(encodedValue);
        	vault.setVendorName(client);
        	vault.setActive(true);
        	vault.setCreatedDate(new Date());
        	tokenRepo.save(vault);
        }else {
        	return base64Encode(vault.getSecretKey().getBytes(StandardCharsets.UTF_8));
        }
        return base64Encode(encodedValue.getBytes(StandardCharsets.UTF_8));
    }

    private byte[] generateRandomBytes(int size) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[size];
        secureRandom.nextBytes(randomBytes);
        return randomBytes;
    }

    private String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
