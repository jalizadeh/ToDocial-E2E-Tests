package main.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProvider {

    final String CONFIG_FILENAME = "config.properties";

    private static DataProvider instance;
    private Properties properties = new Properties();


    private DataProvider(){
        loadProperties();
    }

    public static DataProvider getInstance(){
        if(instance == null){
            synchronized (DataProvider.class){
                if(instance == null){
                    instance = new DataProvider();
                }
            }
        }
        return instance;
    }

    private void loadProperties(){
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILENAME)) {
            if(inputStream == null){
                System.out.println("Unable to find file: " + CONFIG_FILENAME);
                return;
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public String homepage(){
        return getProperty("domain");
    }

    public String page(String page){
        return homepage() + "/" + page;
    }
}
