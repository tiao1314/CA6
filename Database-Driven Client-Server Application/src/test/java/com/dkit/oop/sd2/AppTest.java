package com.dkit.oop.sd2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static UserDaoInterface userDao;
    
    @Before
    static void setUp() {
        userDao = new MySqlUserDao();
    }

    @Test
    void testFindAllUsers() {
        try {
            List<User> users = userDao.findAllUsers();
            assertFalse(users.isEmpty());
        } catch (DaoException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testFindUserById() {
        try {
            User user = userDao.findUserById(1);
            assertNotNull(user);
            assertEquals(1, user.getId());
        } catch (DaoException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
