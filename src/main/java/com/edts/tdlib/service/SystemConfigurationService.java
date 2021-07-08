package com.edts.tdlib.service;

import com.edts.tdlib.model.SystemConfiguration;
import com.edts.tdlib.repository.SystemConfigurationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemConfigurationService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final SystemConfigurationRepo systemConfigurationRepo;

    public SystemConfigurationService(SystemConfigurationRepo systemConfigurationRepo) {
        this.systemConfigurationRepo = systemConfigurationRepo;
    }

    public void setSystemConfiguration(String groupKey, String keyParam, String value) {
        Optional<SystemConfiguration> optionalSystemConfiguration = systemConfigurationRepo.findByGroupKeyAndKeyParam(groupKey, keyParam);
        if (optionalSystemConfiguration.isPresent()) {
            SystemConfiguration systemConfiguration = optionalSystemConfiguration.get();
            systemConfiguration.setValueParam(value);
            systemConfigurationRepo.save(systemConfiguration);
        }
    }


}
