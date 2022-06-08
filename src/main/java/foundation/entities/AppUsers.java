package foundation.entities;

import java.util.Objects;

public class AppUsers {
    private int appUsersId;
    private String username;
    private String password;

    public AppUsers() {
        super();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUsers appUsers = (AppUsers) o;
        return appUsersId == appUsers.appUsersId && Objects.equals(username, appUsers.username) && Objects.equals(password, appUsers.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUsersId, username, password);
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


