package com.esliceu.Figures.utils;

import java.io.InputStream;
import java.util.Properties;

public class MyProperties {
    public Properties getProps(){
        Properties props = new Properties();
        try{
            String propFileName = "config.properties";
            InputStream is = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (is != null){
                props.load(is);
            }
            return props;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
