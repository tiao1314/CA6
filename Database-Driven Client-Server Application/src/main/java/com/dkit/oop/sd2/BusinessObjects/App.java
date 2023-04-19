package com.dkit.oop.sd2.BusinessObjects;

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        UserDaoInterface IUserDao = new MySqlUserDao();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n MENU");
            System.out.println("1. Find all Users");
            System.out.println("2. Find a User by ID");
            System.out.println("3. Delete a User by ID");
            System.out.println("4. Insert an Entity in the database using DAO");
            System.out.println("5. List entities using a filter");
            System.out.println("6. Create a Cache using a HashSet that will maintain the ids of all players");
            System.out.println("7.  Find a single Entity by Key as a JSON String");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice (1-8): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        List<User> users = IUserDao.findAllUsers();
                        if (users.isEmpty()) {
                            System.out.println("=========================================");
                            System.out.println("There are no Users");
                        } else {
                            System.out.println("=========================================");
                            System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
                                    "ID", "First Name", "Last Name", "Age", "Email", "Website");
                            for (User user : users) {
                                System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
                                        user.getId(), user.getFirstName(), user.getLastName(),
                                        user.getAge(), user.getEmail(), user.getWebsite());
                            }
                        }
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter the ID of the User to find: ");
                    int idToFind = scanner.nextInt();
                    try {
                        User user = IUserDao.findUserById(idToFind);
                        if (user != null) {
                            System.out.println("=========================================");
                            System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
                                    "ID", "First Name", "Last Name", "Age", "Email", "Website");
                            System.out.format("%-5s%-15s%-15s%-5s%-35s%-25s\n",
                                    user.getId(), user.getFirstName(), user.getLastName(),
                                    user.getAge(), user.getEmail(), user.getWebsite());
                        } else {
                            System.out.println("User with ID " + idToFind + " not found.");
                        }
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.print("Enter the ID of the User to delete: ");
                    int idToDelete = scanner.nextInt();
                    try {
                        IUserDao.deleteUserById(idToDelete);
                        System.out.println("User with ID " + idToDelete + " has been deleted.");
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    System.out.println("Quited Successfully");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);
    }

}
