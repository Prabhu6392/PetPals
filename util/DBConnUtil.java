package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Properties;

public class DBConnUtil {

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
       
        Properties properties = DBPropertyUtil.getProperties("resources/database.properties");
        
        String driver = properties.getProperty("db.driver");
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        
        Class.forName(driver);
        
        
        return DriverManager.getConnection(url, user, password);
    }
}
