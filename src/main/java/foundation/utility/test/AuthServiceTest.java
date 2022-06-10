package foundation.utility.test;

import foundation.entities.AppUsers;
import foundation.services.AuthService;
import foundation.services.UserService;
import foundation.utility.exceptions.InvalidCredentialsException;
import foundation.utility.exceptions.UsernameNotAvailableException;

public class AuthServiceTest {

    private static AuthService authService;
    private static UserService userService;

    private AppUsers USER_TO_REGISTER;
    private AppUsers GENERIC_USER_1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        authService = new AuthService();
    }

    @Before
    public void setUp() throws Exception {
        userService = mock(UserService.class);
        authService.userService = userService;

        USER_TO_REGISTER = new User(0, "genericEmployee1", "genericPassword");
        GENERIC_USER_1 = new User(1, "genericEmployee1", "genericPassword");
    }

    @Test
    public void testRegisterFailsWhenUsernameIsTaken() {
        when(userService.getByUsername(any(String.class))).thenReturn(GENERIC_USER_1);

        assertThrows(UsernameNotAvailableException.class, () -> authService.register(USER_TO_REGISTER));

        verify(userService).getByUsername(GENERIC_USER_1.getUsername());
        verify(userService, never()).insert(USER_TO_REGISTER);
    }

    @Test
    public void testLoginFailsWhenPasswordIncorrect() {
        when(userService.getByUsername(any(String.class))).thenReturn(GENERIC_USER_1);

        assertThrows(InvalidCredentialsException.class, ()
                -> authService.login(GENERIC_USER_1.getUsername(), "wrongPassword"));

        verify(userService).getByUsername(GENERIC_USER_1.getUsername());


    }
    @Test
    public void testLoginFailsWhenUsernameDoesNotExist() {
        when(userService.getByUsername(any(String.class))).thenReturn(null);

        assertThrows(InvalidCredentialsException.class, ()
                -> authService.login(GENERIC_USER_1.getUsername(), GENERIC_USER_1.getPassword()));

        verify(userService).getByUsername(GENERIC_USER_1.getUsername());
    }
}

