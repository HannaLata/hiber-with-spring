package com.hannalata.dao;

import com.hannalata.config.AppConfig;
import com.hannalata.model.*;
import com.hannalata.model.Order;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
class OrderDAOTest {

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    CartDAO cartDAO;

    List<Order> orders;
    List<User> users;
    List<Item> items;
    List<Cart> carts;

    private static final long CURRENT_TIME = new Date().getTime();

    @BeforeEach
    void setUp() {
        orders = new ArrayList<>();
        users = new ArrayList<>();
        items = new ArrayList<>();
        carts = new ArrayList<>();

        User user = new User("testLogin", "testPassword", "testName",
                "testLastName", "testEmail", "testPhone");
        users.add(user);
        userDAO.save(user);
        Item item = new Item("testCode",  "testName",
                1000, 1);
        items.add(item);
        itemDAO.save(item);
        Cart cart = new Cart(Status.OPEN, user, CURRENT_TIME);
        carts.add(cart);
        cartDAO.save(cart);
        Order order = new Order(item, cart, 5);
        orders.add(order);
    }

    @AfterEach
    void tearDown() {
        orders.forEach(it -> orderDAO.delete(it));
    }

    @Test
    void saveAndGetAndDelete() {

        Order savedOrder = orderDAO.save(orders.get(0));
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());

        Order retrievedOrder = orderDAO.findOne(savedOrder.getId());
        assertNotNull(retrievedOrder);
        assertEquals(5, retrievedOrder.getAmount());


    }
}

