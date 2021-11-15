package com.esliceu.Figures.services;

import com.esliceu.Figures.daos.UserDao;
import com.esliceu.Figures.daos.UserDaoImpl;
import com.esliceu.Figures.models.User;

import org.springframework.stereotype.Service;

import java.util.List;

public interface LoginService {

    public boolean loginOk(String username, String password);
    public boolean registerOk(String username, String password);

}
