package com.esliceu.Figures.daos;

import com.esliceu.Figures.utils.MyProperties;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {

    MyProperties myProperties = new MyProperties();

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
