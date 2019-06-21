package pl.sauermann.springboot.server.propertymanagementservice.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveNewUser(UserDTO UserDTO) {
        User user = userMapper.userDTOToUser(UserDTO);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO changeUserById(Long id, UserDTO UserDTO) {
        User user = userMapper.userDTOToUser(UserDTO);
        User userById = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id" + id + "not exist"));
        userById.setRole(user.getRole());
        userById.setPasswordHash(user.getPasswordHash());
        return userMapper.userToUserDTO(userRepository.save(userById));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserById(Long id) {
        User userById = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id" + id + "not exist"));
        return userMapper.userToUserDTO(userById);
    }
}
