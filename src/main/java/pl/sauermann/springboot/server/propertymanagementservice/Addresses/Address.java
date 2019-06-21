package pl.sauermann.springboot.server.propertymanagementservice.Addresses;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    private String street;
    private String streetNo;
    private String flatNo;
    private String zipCode;
    private String city;
}
