package foundation.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    public static Connection getConnection(){
        try {
            String dbInfo = System.getenv("DB_Connection");
            Connection connection = DriverManager.getConnection( dbInfo);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
