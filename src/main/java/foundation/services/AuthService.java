package foundation.services;

import foundation.daos.AppUsersDAO;
import foundation.entities.AppUsers;
import foundation.utility.exceptions.InvalidCredentialsException;

public class AuthService {
    UserService userService = new UserService();
    private Object AppUsers;

    public AppUsers login(String username, String password) {

        AppUsers user = new AppUsers;

        AppUsers = userService.getByUsername(username);
        
        
        if (userService !=null && password.equals(user.getPassword())) {
            
            System.out.println("Logged In Successfully");
            return user;
        } else if (userService !=null && !password.equals(user.getPassword())) {
            
            System.out.println("Wrong Password");
            throw new InvalidCredentialsException("Wrong Password Entered.");
            
        } else {
            
            System.out.println("User Does Not Exist!");
            throw new InvalidCredentialsException("User Does Not Exist.");
        }

    }
}
