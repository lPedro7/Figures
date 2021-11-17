package com.esliceu.Figures.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

@Component
public class MyProperties {

    @Bean
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
