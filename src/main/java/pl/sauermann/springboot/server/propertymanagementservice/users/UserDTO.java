package pl.sauermann.springboot.server.propertymanagementservice.users;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String login;
    private Role role;
}
