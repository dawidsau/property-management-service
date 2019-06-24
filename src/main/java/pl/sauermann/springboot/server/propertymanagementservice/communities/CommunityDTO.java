package pl.sauermann.springboot.server.propertymanagementservice.communities;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.addresses.AddressDTO;
import pl.sauermann.springboot.server.propertymanagementservice.estates.EstateDTO;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCardDTO;

import java.util.Set;

@Data
public class CommunityDTO {

    private Long id;
    private String name;
    private AddressDTO address;
    private Set<PaymentCardDTO> paymentCards;
    private Set<EstateDTO> estates;
}
