package com.hannalata.dao;

import com.hannalata.config.AppConfig;
import com.hannalata.model.*;
import com.hannalata.model.Order;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
class CartDAOTest {

    @Autowired
    CartDAO cartDAO;
    @Autowired
    UserDAO userDAO;

    List<Cart> carts;
    List<User> users;

    private static final long CURRENT_TIME = new Date().getTime();

    @BeforeEach
    void setUp() {
        carts = new ArrayList<>();
        users = new ArrayList<>();
        User user = new User("testLogin", "testPassword", "testName",
                "testLastName", "testEmail", "testPhone");
        users.add(user);
        userDAO.save(user);
        Cart cart = new Cart(Status.OPEN, user, CURRENT_TIME);
        carts.add(cart);
    }

       @AfterEach
       void tearDown() {
        carts.forEach(it -> cartDAO.delete(it));
    }

    @Test
    void saveAndGetAndDelete() {

        Cart savedCart = cartDAO.save(carts.get(0));
        assertNotNull(savedCart);
        assertNotNull(savedCart.getId());

        Cart retrievedCart = cartDAO.findOne(savedCart.getId());
        assertNotNull(retrievedCart);
        assertEquals(Status.OPEN, retrievedCart.getStatus());


    }


}