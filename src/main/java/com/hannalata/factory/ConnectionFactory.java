package com.hannalata.factory;

import org.hibernate.SessionFactory;

public interface ConnectionFactory {

    SessionFactory getSessionFactory();
}
