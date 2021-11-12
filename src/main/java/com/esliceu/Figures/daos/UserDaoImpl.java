package com.esliceu.Figures.daos;

import com.esliceu.Figures.models.User;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    Database db = new Database();

    @Override
    public User getUser(String username) {
        Connection con = db.getConnection();

        try {

            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM User WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                String us = rs.getString(1);
                String password = rs.getString(2);

                User u = new User();
                u.setUsername(us);
                u.setPassword(password);


                preparedStatement.close();


                return u;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<User> getUsers() {

        Connection con = db.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM User");
            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {

                User u = new User();

                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                users.add(u);
            }
            ps.close();
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void createUser(User user) {

        Connection con = db.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO User('username','password') VALUES(?,?)");

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
