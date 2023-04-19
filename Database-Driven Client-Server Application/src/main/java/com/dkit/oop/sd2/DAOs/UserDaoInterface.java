package com.dkit.oop.sd2.DAOs;



import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;
import java.util.Comparator;
import java.util.HashSet;


public interface UserDaoInterface {
    
    // Feature 1 – Find all Entities e.g. findAllPlayers() to return a List of all the entities and display that list
    List<User> findAllUsers() throws DaoException;

    //Feature 2 – Find and Display (a single) Entity by Key e.g. findPlayerById( id ) – return a single entity and display its contents.
    public User findUserById(int id) throws DaoException;

    //Feature 3 – Delete an Entity by key e.g. deletePlayerById( id ) – remove entity from database
    void deleteUserById(int id) throws DaoException; // void means no return value

    //Feature 4 – Insert an Entity in the database using DAO (gather data from user, store in DTO object, pass into method insertPlayer ( Player ), return new entity including assigned auto-id.
    User insertUser(User user) throws DaoException;
    
    //Feature 5 – List entities using a filter e.g. findPlayerUsingFilter( playerAgeComparator )
    //List<User> findUserUsingFilter(Comparator<User> comparator) throws DaoException;

    //Feature 6 - Create a Cache using a HashSet that will maintain the ids of all users and
    //refactor the findUserById() method so that it checks for the existence of a user id before
    //it makes a query to the SQL database.
    //HashSet<Integer> createCache() throws DaoException;
}

