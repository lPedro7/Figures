package com.esliceu.Figures.daos;

import com.esliceu.Figures.utils.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@Component
public class Database {

    MyProperties myProperties;

    public Connection getConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");

            Properties properties = myProperties.getProps();
            String jdbcStr = properties.getProperty("jdbcstring3");

            Connection con =  DriverManager.getConnection(jdbcStr);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
