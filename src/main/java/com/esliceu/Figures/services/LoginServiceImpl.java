package com.esliceu.Figures.services;

import com.esliceu.Figures.daos.UserDao;
import com.esliceu.Figures.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserDao userDao;

    @Override
    public boolean loginOk(String username, String password) {

        if (username == null || password == null) return false;

        User u = userDao.getUser(username);

        if (u == null) {
            return false;
        } else return u.getPassword().equals(password);
    }

    @Override
    public boolean registerOk(String username, String password) {

        if (!username.matches(".{6,20}")) return false;
        if (!password.matches(".{8,20}")) return false;

        List<User> users = userDao.getUsers();

        if (users == null) return false;

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return false;
            }
        }
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);

        userDao.createUser(u);
        return true;
    }

}
