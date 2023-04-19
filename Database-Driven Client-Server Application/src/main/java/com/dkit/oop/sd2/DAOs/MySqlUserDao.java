package com.dkit.oop.sd2.DAOs;




    import com.dkit.oop.sd2.DTOs.User;
    import com.dkit.oop.sd2.Exceptions.DaoException;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Comparator;
    


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
        String sql = "SELECT * FROM developers WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"),
                                     rs.getString("first_name"),
                                     rs.getString("last_name"),
                                     rs.getInt("age"),
                                     rs.getString("email"),
                                     rs.getString("website"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DaoException("Error finding developers with ID " + id + ": " + e.getMessage());
        }
    }
    
    @Override
    public void deleteUserById(int id) throws DaoException {
        String sql = "DELETE FROM developers WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new DaoException("User with ID " + id + " does not exist.");
            }
        } catch (SQLException e) {
            throw new DaoException("Error deleting user with ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public User insertUser(User user) throws DaoException {
        String sql = "INSERT INTO developers (first_name, last_name, age, email, website) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = this.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getWebsite());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new DaoException("Error inserting user.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new DaoException("Error inserting user.");
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error inserting user: " + e.getMessage());
        }
        return user;
    }

    
}

    
    




    
    
    
    


