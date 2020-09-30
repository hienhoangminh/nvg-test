package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    public static String getPropertyByName(String name) throws IOException {
        InputStream input = new FileInputStream("applicationContext.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(name);
    }
}
