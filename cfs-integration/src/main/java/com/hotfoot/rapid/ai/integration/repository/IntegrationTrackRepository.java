package com.hotfoot.rapid.ai.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotfoot.rapid.ai.integration.datamodel.IntegrationTrackModel;

public interface IntegrationTrackRepository extends JpaRepository<IntegrationTrackModel, Long> {

}
