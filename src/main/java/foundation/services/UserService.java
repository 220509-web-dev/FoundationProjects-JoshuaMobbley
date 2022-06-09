package foundation.services;

import foundation.daos.AppUsersDaoPostgres;
import foundation.entities.AppUsers;
import foundation.utility.exceptions.InvalidRequestException;

public class UserService {

    public AppUsers createNewUser(AppUsers newUser) {

        private final AppUsersDaoPostgres usersDAO;

        public UserService(AppUsersDaoPostgres usersDAO) {
            this.usersDAO = usersDAO;
        }

        if(newUser == null || newUser.getUsername() == null || newUser.getUsername().equals("") ||
        newUser.getPassword() == null || newUser.getPassword().equals("")) {

            String msg = "Provided data was invalid. Username or password text must not be null or empty!";
            throw new InvalidRequestException(msg);
        }

        return usersDAO.save(newUser);


    }
}
