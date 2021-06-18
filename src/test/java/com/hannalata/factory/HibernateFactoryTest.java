package com.hannalata.factory;

import com.hannalata.config.AppConfig;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
class HibernateFactoryTest {

    @Autowired
    ConnectionFactory connectionFactory;

    @Test
    void getSessionFactory() {

        SessionFactory sessionFactory = connectionFactory.getSessionFactory();
        assertNotNull(sessionFactory);
    }
}