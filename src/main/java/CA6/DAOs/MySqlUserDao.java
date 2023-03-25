package CA6.DAOs;

import CA6.DTOs.User;
import CA6.Exceptions.DaoException;
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
                User user = new User(id, firstName, lastName, age, email, website);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Error finding all developers: " + e.getMessage());
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
    
}
