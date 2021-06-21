package com.hannalata.dao;

import com.hannalata.config.AppConfig;
import com.hannalata.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
@ActiveProfiles("test")
class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    List<User> users;
    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        User user = new User("myhailovna", "monolit7",
                "Hanna", "Lata", "test@gmail.com", "0975554433");
        users.add(user);
    }


    @Test
    void saveAndGetAndDelete() {

        User savedUser = userDAO.save(users.get(0));
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());

        User retrievedUser = userDAO.findOne(savedUser.getId());
        assertNotNull(retrievedUser);
        assertEquals("myhailovna", retrievedUser.getLogin());

        userDAO.delete(retrievedUser);
        User deletedUser = userDAO.findOne(savedUser.getId());
        assertNull(deletedUser);

    }
}