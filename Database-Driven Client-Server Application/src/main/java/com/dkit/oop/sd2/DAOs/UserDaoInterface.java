package com.dkit.oop.sd2.DAOs;



import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.util.List;

public interface UserDaoInterface {
    
    // Feature 1 – Find all Entities e.g. findAllPlayers() to return a List of all the entities and display that list
    List<User> findAllUsers() throws DaoException;

    //Feature 2 – Find and Display (a single) Entity by Key e.g. findPlayerById( id ) – return a single entity and display its contents.
    public User findUserById(int id) throws DaoException;
}

