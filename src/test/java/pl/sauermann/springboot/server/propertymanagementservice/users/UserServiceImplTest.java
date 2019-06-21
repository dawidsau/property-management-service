package pl.sauermann.springboot.server.propertymanagementservice.users;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    private User returnUser;
    private UserDTO insertedUser;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository);

        returnUser = new User();
        returnUser.setLogin("Login");
        returnUser.setId(1L);

        insertedUser = new UserDTO();
        insertedUser.setLogin("Login");
        insertedUser.setId(1L);
    }

    @Test
    public void saveNewUser() {
        when(userRepository.save(any(User.class))).thenReturn(returnUser);

        UserDTO result = userService.saveNewUser(insertedUser);

        assertEquals(returnUser.getLogin(), result.getLogin());
        assertEquals(returnUser.getId(), result.getId());
    }

    @Test
    public void changeUserById() {
        when(userRepository.save(any(User.class))).thenReturn(returnUser);
        when(userRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnUser));

        UserDTO result = userService.changeUserById(1L, insertedUser);

        assertEquals(returnUser.getLogin(), result.getLogin());
        assertEquals(returnUser.getId(), result.getId());
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(anyLong());

        verify(userRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void findUserById() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnUser));

        UserDTO result = userService.findUserById(1L);

        assertEquals(returnUser.getLogin(), result.getLogin());
        assertEquals(returnUser.getId(), result.getId());
    }
}