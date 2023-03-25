package com.dkit.oop.sd2.BusinessObjects;


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


            // Call Feature 2: Find a User by ID
            System.out.println("\n findUserById(1)");
            User user = IUserDao.findUserById(1);

            if (user != null) {
                System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
                        "ID", "First Name", "Last Name", "Age", "Email", "Website");
                System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
                        user.getId(), user.getFirstName(), user.getLastName(),
                        user.getAge(), user.getEmail(), user.getWebsite());
            } else {
                System.out.println("User with ID 1 not found.");
            }

            // Call Feature 3: Delete User by ID
        int idToDelete = 2;  // specify the ID of the user to delete
        IUserDao.deleteUserById(idToDelete);
        System.out.println("User with ID " + idToDelete + " has been deleted.");



        }
    }
        catch (DaoException e)
        {
            e.printStackTrace();
        }
    }

    
}