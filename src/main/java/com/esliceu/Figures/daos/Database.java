package com.esliceu.Figures.daos;

import com.esliceu.Figures.utils.MyProperties;

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
            String msi = "C:\\Users\\pedro\\Dropbox\\2daw\\21-22\\Servidor\\Projects\\Figures\\src\\main\\resources\\figura.db";
            String jdbcStr = properties.getProperty("jdbcstring2");

            System.out.println(jdbcStr);

            Connection con =  DriverManager.getConnection(jdbcStr);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}