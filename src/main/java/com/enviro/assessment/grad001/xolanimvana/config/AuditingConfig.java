package com.enviro.assessment.grad001.xolanimvana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // Enables auditing annotations
public class AuditingConfig {
}
