package com.nation.dungeon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String getApiKey() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(".env"));
            return props.getProperty("API_KEY");
        } catch (IOException e) {
            System.err.println("Could not find/read .env");
            return null;
        }
    }
}