package foundation.entities;

public class AppUsers {
    private int appUsersId;
    private String username;
    private String password;

    public AppUsers() {
    }

    public AppUsers(int appUsersId, String username, String password) {
        this.appUsersId = appUsersId;
        this.username = username;
        this.password = password;
    }

    public int getAppUsersId() {
        return appUsersId;
    }

    public void setAppUsersId(int appUsersId) {
        this.appUsersId = appUsersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppUsers{" +
                "appUsersId=" + appUsersId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void add(AppUsers appUsers) {
    }
}


