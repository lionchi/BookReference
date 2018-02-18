package ru.gavrilov.core.helpers;

import java.io.IOException;
import java.util.Properties;

public class LoadProperty {
    public static Properties loadProperty(){
        Properties properties = new Properties();
        try {
            properties.load(LoadProperty.class.getClassLoader().getResourceAsStream("dev.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
