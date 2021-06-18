package com.hannalata;

import com.hannalata.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.hannalata");
        UserDAO userDAO = context.getBean(UserDAO.class);

        System.out.println(userDAO.toString());

    }
}
