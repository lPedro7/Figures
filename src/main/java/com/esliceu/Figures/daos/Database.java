package com.esliceu.Figures.daos;

import com.esliceu.Figures.utils.MyProperties;
import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


@Component
public class Database {

    @Autowired
    MyProperties myProperties;

    @Bean
    public Connection getConnection()
    {
        Connection con = null;
        try {
            //Class.forName("org.sqlite.JDBC");
Class.forName("com.mysql.cj.jdbc.Driver");
            Properties properties = myProperties.getProps();

Properties info = new Properties();
info.put("user","root");
info.put("password","root");

            String jdbcStr = properties.getProperty("jdbcstring3");
            String url = "jdbc:mysql://localhost:3306/figuras";
            //con =  DriverManager.getConnection("jdbc:sqlite:webapps\\ROOT\\WEB-INF\\classes\\figura.db");
            con =  DriverManager.getConnection(url,info);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
