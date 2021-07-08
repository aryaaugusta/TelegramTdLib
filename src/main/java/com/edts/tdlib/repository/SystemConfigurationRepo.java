package com.edts.tdlib.repository;

import com.edts.tdlib.model.SystemConfiguration;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SystemConfigurationRepo extends CrudRepository<SystemConfiguration, Long> {

    Optional<SystemConfiguration> findByGroupKeyAndKeyParam(String groupKey, String keyParam);

}
