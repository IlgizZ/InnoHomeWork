package students.dao;

import org.apache.log4j.Logger;
import students.logic.ManagementSystem;
import students.logic.RegisteredUser;
import students.logic.Student;
import students.web.RegisterServlet;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya Evlampiev on 05.10.2015.
 */
public class RegisteredUserDAO {
    static Logger log = Logger.getLogger(RegisteredUserDAO.class);

    public List<RegisteredUser> list() throws SQLException {

        List<RegisteredUser> users = new ArrayList<RegisteredUser>();

        Connection connection = ManagementSystem.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT user_name, user_pass, email FROM users");
        ResultSet resultSet = statement.executeQuery();

        {
            while (resultSet.next()) {
                RegisteredUser user = new RegisteredUser();
                user.setUsername(resultSet.getString("user_name"));
                user.setPasswordHash(resultSet.getString("user_pass"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        }
        return users;
    }

    public boolean addUser(RegisteredUser user, String role)
    {
        Connection connection = ManagementSystem.getInstance().getConnection();
        log.trace("Connection established");
        try {
            connection.setAutoCommit(false);

//неправильно сделано - сначла кладем связь
            PreparedStatement stmt2 = null;
            stmt2 = connection.prepareStatement("INSERT INTO user_roles "
                    + "(user_name, role_name)"
                    + "VALUES( ?,  ?)");
            stmt2.setString(1, user.getUsername());
            stmt2.setString(2, role);
            stmt2.execute();
            log.trace("Addition to user_roles");

            //и только затем саму сущность
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("INSERT INTO users "
                    + "(user_name, user_pass, email)"
                    + "VALUES( ?,  ?,  ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            stmt.execute();
            log.trace("Addition to users");
            connection.commit();
            stmt.close();
            stmt2.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if(connection!=null) connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                log.error("Rollback failed");
            }
            log.error("Addition on new user failed "+e.getLocalizedMessage());
            return false;
        }
    }

    public boolean updateUser(String oldusername, RegisteredUser user, String new_role, InputStream is)
    {
        Connection connection = ManagementSystem.getInstance().getConnection();
        log.trace("Connection established");
        try {
            connection.setAutoCommit(false);

//неправильно сделано - сначла кладем связь
            PreparedStatement stmt2 = null;
            stmt2 = connection.prepareStatement("UPDATE user_roles SET user_name =  ?, role_name=? " +
                                    "WHERE user_name =  ?");
            stmt2.setString(1, user.getUsername());
            stmt2.setString(2, new_role);
            stmt2.setString(3,oldusername);
            stmt2.execute();
            log.trace("Update to user_roles");

            //и только затем саму сущность
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("UPDATE users SET user_name =  ?, user_pass=?, email=?, photo=? " +
                                                        "WHERE user_name =  ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            if (is != null) {
                // fetches input stream of the upload file for the blob column
                stmt.setBlob(4, is);
            }
            stmt.setString(5, oldusername);

            stmt.execute();
            log.trace("Update to users");
            connection.commit();
            stmt.close();
            stmt2.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if(connection!=null) connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                log.error("Rollback failed");
            }
            log.error("Update on new user failed "+e.getLocalizedMessage());
            return false;
        }
    }

    public RegisteredUser getUserByName(String username) throws SQLException {
        Connection connection = ManagementSystem.getInstance().getConnection();
        log.trace("Connection established");
        RegisteredUser user = new RegisteredUser();
        PreparedStatement stmt = connection.prepareStatement("SELECT user_name, user_pass, email FROM users WHERE user_name = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            user.setUsername(rs.getString("user_name"));
            user.setPasswordHash(rs.getString("user_pass"));
            user.setEmail(rs.getString("email"));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public Blob getBlob(String username) throws SQLException {
        Connection connection = ManagementSystem.getInstance().getConnection();
        log.trace("Connection established");
        //RegisteredUser user = new RegisteredUser();
        Blob photo=null;
        PreparedStatement stmt = connection.prepareStatement("SELECT photo FROM users WHERE user_name = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            photo=rs.getBlob("photo");
        }
        rs.close();
        stmt.close();
        return photo;
    }
}
