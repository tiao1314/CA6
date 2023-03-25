package CA6.DAOs;

import CA6.DTOs.User;
import CA6.Exceptions.DaoException;
import java.util.List;

public interface UserDaoInterface
{
    public List<User> findAllUsers() throws DaoException;

    public User findUserByUsernamePassword(String username, String password) throws DaoException;

}