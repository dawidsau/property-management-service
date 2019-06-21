package pl.sauermann.springboot.server.propertymanagementservice.users;

public interface UserService {

    UserDTO saveNewUser(UserDTO UserDTO);

    UserDTO changeUserById(Long id, UserDTO UserDTO);

    void deleteUserById(Long id);

    UserDTO findUserById(Long id);
}
