package com.dmsc.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class SecurityConfiguration {

    @Bean
    @ConfigurationProperties(EncryptionProperties.PREFIX)
    public EncryptionProperties encryptionProperties() {
        return new EncryptionProperties();
    }

    @Bean
    public PasswordEncoder passwordEncoder(EncryptionProperties encryptionProperties) {
        return new BCryptPasswordEncoder(encryptionProperties.getStrength(), new SecureRandom());
    }

    @Data
    public static class EncryptionProperties {
        public static final String PREFIX = "security.local.encryption";

        private int strength = 15;
    }
}
