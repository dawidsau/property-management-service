package pl.sauermann.springboot.server.propertymanagementservice.owners;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.addresses.AddressDTO;
import pl.sauermann.springboot.server.propertymanagementservice.communities.CommunityDTO;
import pl.sauermann.springboot.server.propertymanagementservice.estates.EstateDTO;

import java.util.Set;

@Data
public class OwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String phone;
    private String email;
    private Boolean emailNotification;
    private AddressDTO address;
    private AddressDTO correspondenceAddress;
    private Set<EstateDTO> estates;
    private Set<CommunityDTO> communities;
}
