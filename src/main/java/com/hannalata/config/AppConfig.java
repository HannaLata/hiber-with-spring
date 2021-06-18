package com.hannalata.config;

import com.hannalata.dao.ItemDAO;
import com.hannalata.dao.UserDAO;
import com.hannalata.factory.ConnectionFactory;
import com.hannalata.factory.H2Factory;
import com.hannalata.factory.PostgresFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.hannalata")
public class AppConfig {

    @Bean
    @Qualifier(value = "h2")
    @Profile("test")
    public ConnectionFactory getH2Factory() {
        return new H2Factory();
    }

    @Bean
    @Qualifier(value = "postgres")
    @Profile("prod")
    public ConnectionFactory getPostgresFactory() {
        return new PostgresFactory();
    }




}
