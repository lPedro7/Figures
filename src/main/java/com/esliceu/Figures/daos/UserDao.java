package com.esliceu.Figures.daos;

import com.esliceu.Figures.models.User;

import java.util.List;

public interface UserDao {
    User getUser(String username);
    List<User> getUsers();
    void createUser(User user);
}
