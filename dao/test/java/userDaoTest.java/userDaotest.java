package com.mycart.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private UserDao userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
    }

    @Test
    void testAddUser() {
        userDao.addUser(1, "John Doe");
        assertEquals("John Doe", userDao.getUserById(1), "User should be added successfully");
    }

    @Test
    void testGetUserById_existingUser() {
        userDao.addUser(2, "Jane Smith");
        String user = userDao.getUserById(2);
        assertEquals("Jane Smith", user, "Should return the correct user for the given ID");
    }

    @Test
    void testGetUserById_nonExistingUser() {
        String user = userDao.getUserById(99);
        assertNull(user, "Should return null for a non-existing user ID");
    }

    @Test
    void testDeleteUser() {
        userDao.addUser(3, "Alice Johnson");
        userDao.deleteUser(3);
        assertNull(userDao.getUserById(3), "User should be deleted successfully");
    }
}
