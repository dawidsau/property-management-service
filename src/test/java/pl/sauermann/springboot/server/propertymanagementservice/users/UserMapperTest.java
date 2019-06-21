package pl.sauermann.springboot.server.propertymanagementservice.users;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {

    UserMapper userMapper = UserMapper.INSTANCE;

    User user;
    UserDTO userDTO;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setLogin("ds@ds.com");

        userDTO = new UserDTO();
        userDTO.setLogin("ds@ds.com");
    }

    @Test
    public void userDTOToUser() {
        User result = userMapper.userDTOToUser(userDTO);

        assertEquals(user, result);
    }

    @Test
    public void userToUserDTO() {
        UserDTO result = userMapper.userToUserDTO(user);

        assertEquals(userDTO, result);
    }
}