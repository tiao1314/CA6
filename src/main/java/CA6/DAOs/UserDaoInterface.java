package CA6.DAOs;

import CA6.DTOs.User;
import CA6.Exceptions.DaoException;
import java.util.List;

public interface UserDaoInterface {
    
    // Feature 1 – Find all Entities e.g. findAllPlayers() to return a List of all the entities and display that list
    List<User> findAllUsers() throws DaoException;

    
    
}