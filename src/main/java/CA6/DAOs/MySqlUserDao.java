package CA6.DAOs;

import CA6.DTOs.User;
import CA6.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlUserDao extends MySqlDao implements UserDaoInterface
{

    @Override
public List<User> findAllUsers() throws DaoException
{
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;
    List<User> usersList = new ArrayList<>();

    try
    {
        //Get connection object using the methods in the super class (MySqlDao.java)...
        connection = this.getConnection();

        String query = "SELECT * FROM developers";
        ps = connection.prepareStatement(query);

        //Using a PreparedStatement to execute SQL...
        resultSet = ps.executeQuery();
        while (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            String website = resultSet.getString("website");
            User u = new User(id, firstName, lastName, age, email, website);
            usersList.add(u);
        }
    } catch (SQLException e)
    {
        throw new DaoException("findAllUsers() " + e.getMessage());
    } finally
    {
        try
        {
            if (resultSet != null)
            {
                resultSet.close();
            }
            if (ps != null)
            {
                ps.close();
            }
            if (connection != null)
            {
                freeConnection(connection);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllUsers() " + e.getMessage());
        }
    }
    return usersList;     // may be empty
}

@Override
public User findUserByUsernamePassword(String user_name, String pass_word) throws DaoException
{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User user = null;
    try
    {
        connection = this.getConnection();

        String query = "SELECT * FROM developers WHERE email = ? AND password = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, pass_word);

        resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
        {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            String website = resultSet.getString("website");

            user = new User(id, firstName, lastName, age, email, website);
        }
    } catch (SQLException e)
    {
        throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
    } finally
    {
        try
        {
            if (resultSet != null)
            {
                resultSet.close();
            }
            if (preparedStatement != null)
            {
                preparedStatement.close();
            }
            if (connection != null)
            {
                freeConnection(connection);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
        }
    }
    return user;     // reference to User object, or null value
}

}