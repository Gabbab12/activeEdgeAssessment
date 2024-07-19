package com.activedge.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class FlywayMigrationConfig {
    @Bean
    public FlywayMigrationStrategy repair() {
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }
}
