package pl.sauermann.springboot.server.propertymanagementservice.users;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);
}
