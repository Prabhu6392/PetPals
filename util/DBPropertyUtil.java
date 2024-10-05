package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static Properties getProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream(fileName);
        properties.load(input);
        input.close();
        return properties;
    }
}
