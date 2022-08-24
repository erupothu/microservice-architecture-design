package com.example.configserver.config;

import org.springframework.cloud.vault.config.SecretBackendConfigurer;
import org.springframework.cloud.vault.config.VaultConfigurer;

public class VaultConfig implements VaultConfigurer {

    @Override
    public void addSecretBackends(SecretBackendConfigurer configurer) {
        // TODO Auto-generated method stub
        configurer.add("secret/config-server-db");

        configurer.registerDefaultGenericSecretBackends(false);
        configurer.registerDefaultDiscoveredSecretBackends(true);
    }
    
}
