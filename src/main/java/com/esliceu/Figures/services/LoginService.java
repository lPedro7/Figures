package com.esliceu.Figures.services;

import com.esliceu.Figures.daos.UserDao;
import com.esliceu.Figures.daos.UserDaoImpl;
import com.esliceu.Figures.models.User;

import java.util.List;
import java.util.regex.Pattern;

public class LoginService {

    UserDao userDao = new UserDaoImpl();
    List<User> users = userDao.getUsers();

    public boolean loginOk(String username, String password) {

        if (username==null || password == null) return false;

        User u = userDao.getUser(username);

        if (u==null){
            return false;
        }else return u.getPassword().equals(password);
    }

    public boolean registerOk(String username, String password){

        if (!username.matches(".{6,20}")) return false;
        if (!password.matches(".{8,20}")) return false;


        for(User u:users){
            if (u.getUsername().equals(username)){
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
