package com.dkit.oop.sd2.DAOs;




import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlUserDao extends MySqlDao implements UserDaoInterface {
    
    @Override
    public List<User> findAllUsers() throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            con = this.getConnection();
            String query = "SELECT * FROM developers";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String website = rs.getString("website");
                // create a new developer object to store the values from the database
                User user = new User(id, firstName, lastName, age, email, website);
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new DaoException("Error finding all developers: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                throw new DaoException("Error closing resources: " + ex.getMessage());
            }
        }
        return users;
    }

    @Override
public User findUserById(int id) throws DaoException {
    String sql = "SELECT * FROM User WHERE id = ?";
    

    
}

