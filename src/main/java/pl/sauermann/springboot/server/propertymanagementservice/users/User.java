package pl.sauermann.springboot.server.propertymanagementservice.users;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    private String passwordHash;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
