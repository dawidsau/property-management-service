package pl.sauermann.springboot.server.propertymanagementservice.Addresses;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String street;
    private String streetNo;
    private String flatNo;
    private String zipCode;
    private String city;
}
