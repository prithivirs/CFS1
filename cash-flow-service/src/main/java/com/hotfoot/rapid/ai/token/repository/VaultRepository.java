package com.hotfoot.rapid.ai.token.repository;

import org.springframework.stereotype.Repository;

import com.hotfoot.rapid.ai.token.datamodel.Vault;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VaultRepository extends JpaRepository<Vault, Long>{
	
	public Vault findByVendorName(String vendor);

}
