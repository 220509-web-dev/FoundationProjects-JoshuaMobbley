package foundation.daos;

import foundation.entities.AppUsers;
import foundation.utility.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppUsersDaoPostgres implements AppUsersDAO {

    @Override
    public AppUsers createUser(AppUsers appUsers) {
        try(Connection conn = ConnectionUtility.getConnection()){
            String sql = "insert into app_users values (default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString( 1, appUsers.getUsername());
            ps.setString( 2, appUsers.getPassword());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt( "id");

            appUsers.setAppUsersId(generatedId);
            return appUsers;
        }  catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public AppUsers getAppUserById(int id) {

        try(Connection conn = ConnectionUtility.getConnection()) {
            String sql = "select * from app_users where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            AppUsers appUsers = new AppUsers();
            appUsers.setAppUsersId(rs.getInt( "id"));
            appUsers.setUsername(rs.getString( "username"));
            appUsers.setPassword(rs.getString("password"));
            return appUsers;

        }  catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<AppUsers> getAllUsers() {

        List<AppUsers> appUsers = new ArrayList<>();

        try(Connection conn = ConnectionUtility.getConnection()){

            System.out.println("[DEBUG] - Connection exists? " + (conn != null));
            String sql = "select * from app_users";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                AppUsers appUser = new AppUsers();
                appUser.setAppUsersId(rs.getInt( "id"));
                appUser.setUsername(rs.getString( "username"));
                appUser.setPassword(rs.getString("password"));
                appUsers.add(appUser);
                System.out.println("[DEBUG] - " + appUser);
            }

        }  catch (SQLException exception) {
            exception.printStackTrace();
        }

        return appUsers;
    }

    @Override
    public AppUsers updateUser(AppUsers appUsers) {
        try(Connection conn = ConnectionUtility.getConnection()) {
            String sql = "update app_users set username = ?, password = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, appUsers.getUsername());
            ps.setString( 2, appUsers.getPassword());
            ps.setInt( 3, appUsers.getAppUsersId());

            ps.execute();
            return appUsers;

        }   catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUserById(int id) {
        try(Connection conn = ConnectionUtility.getConnection()){
            String sql = "delete from app_users where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, id);

            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }


}