package com.hannalata.factory;

import com.hannalata.model.Cart;
import com.hannalata.model.Item;
import com.hannalata.model.Order;
import com.hannalata.model.User;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class PostgresFactory implements ConnectionFactory {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.setProperty("hibernate.connection.driverClassName", "org.postgresql.Driver");
                properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hiber_spring_db");
                properties.setProperty("hibernate.connection.username", "postgres");
                properties.setProperty("hibernate.connection.password", "N1i2k3o4l5a6y7!");
                properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                properties.setProperty("hibernate.hbm2ddl.auto", "update");
                properties.setProperty("hibernate.show_sql", "true");
                properties.setProperty("hibernate.format_sql", "true");

                configuration.addProperties(properties);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                configuration.addAnnotatedClass(Item.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(Cart.class);

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
