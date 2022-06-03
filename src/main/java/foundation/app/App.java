package foundation.app;

import foundation.daos.AppUsersDAO;
import foundation.daos.AppUsersDaoPostgres;
import foundation.entities.AppUsers;
import foundation.utility.ConnectionUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionUtility.getConnection();

       /* String sql = "select * from app_users where id = 1";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        String appUsersName = rs.getString("username");

        System.out.println(appUsersName); */

        AppUsersDAO appUsersDAO = new AppUsersDaoPostgres();
        System.out.println(appUsersDAO.getAllUsers());
    }
}
