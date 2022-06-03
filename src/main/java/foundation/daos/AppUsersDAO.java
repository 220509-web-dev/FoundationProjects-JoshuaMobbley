package foundation.daos;

import foundation.entities.AppUsers;

import java.util.List;

public interface AppUsersDAO {

    AppUsers createUser(AppUsers appUsers);

    AppUsers getAppUserById(int id);
    List<AppUsers> getAllUsers();

    AppUsers updateUser(AppUsers appUsers);

    void deleteUserById(int id);
}
