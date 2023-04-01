package com.damian.hms.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertyInjector {
    public static void injectProperties(){
        Properties properties = new Properties();
        try {
            URL resource = PropertyInjector.class.getResource("/properties/hibernate.properties");
            properties.load(resource.openStream());
        } catch (IOException e) {
            System.out.println("An error occurred in PropertyInjector.injectProperties() : "+e.getLocalizedMessage());
        }
    }
}
