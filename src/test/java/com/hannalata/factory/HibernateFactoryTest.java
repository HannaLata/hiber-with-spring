package com.hannalata.factory;

import com.hannalata.config.DatabaseConfig;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(DatabaseConfig.class)
class HibernateFactoryTest {

    @Autowired
    ConnectionFactory connectionFactory;

    @Test
    void getSessionFactory() {

        SessionFactory sessionFactory = connectionFactory.getSessionFactory();
        assertNotNull(sessionFactory);
    }
}