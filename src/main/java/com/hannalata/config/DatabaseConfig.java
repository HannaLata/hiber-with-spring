package com.hannalata.config;

import com.hannalata.factory.ConnectionFactory;
import com.hannalata.factory.H2Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public ConnectionFactory getConnectionFactory() {
        return new H2Factory();
    }

}
