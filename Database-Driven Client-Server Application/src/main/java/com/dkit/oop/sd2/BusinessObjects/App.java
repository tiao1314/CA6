package com.dkit.oop.sd2.BusinessObjects;

/** OOP Feb 2022
 * This App demonstrates the use of a Data Access Object (DAO)
 * to separate Business logic from Database specific logic.
 * It uses Data Access Objects (DAOs),
 * Data Transfer Objects (DTOs), and  a DAO Interface to define
 * a contract between Business Objects and DAOs.
 *
 * "Use a Data Access Object (DAO) to abstract and encapsulate all
 * access to the data source. The DAO manages the connection with
 * the data source to obtain and store data" Ref: oracle.com
 *
 * Here, we use one DAO per database table.
 *
 * Use the SQL script "CreateUsers.sql" included with this project
 * to create the required MySQL user_database and User table.
 */

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        UserDaoInterface IUserDao = new MySqlUserDao();  //"IUserDao" -> "I" stands for for

        try
        {
            // Call Feature 1: Find all Users
            System.out.println("\n findAllUsers()");
            List<User> users = IUserDao.findAllUsers();     // call a method in the DAO

            if (users.isEmpty())
            {
                System.out.println("There are no Users");
            }
            else
            {
                System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
        "ID", "First Name", "Last Name", "Age", "Email", "Website");
    for (User user : users) {
        System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
            user.getId(), user.getFirstName(), user.getLastName(),
            user.getAge(), user.getEmail(), user.getWebsite());
            }
        }
    }
        catch (DaoException e)
        {
            e.printStackTrace();
        }
    }
}