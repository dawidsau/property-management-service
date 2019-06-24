package pl.sauermann.springboot.server.propertymanagementservice.estates;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.addresses.AddressDTO;
import pl.sauermann.springboot.server.propertymanagementservice.communities.CommunityDTO;
import pl.sauermann.springboot.server.propertymanagementservice.owners.OwnerDTO;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCardDTO;

import java.util.Set;

@Data
public class EstateDTO{

    private Long id;
    private String estateName;
    private EstateSize size;
    private AddressDTO address;
    private CommunityDTO community;
    private Set<PaymentCardDTO> paymentCard;
    private Set<OwnerDTO> owners;
}
