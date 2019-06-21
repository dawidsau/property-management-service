package pl.sauermann.springboot.server.propertymanagementservice.payments;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.communities.CommunityDTO;
import pl.sauermann.springboot.server.propertymanagementservice.estates.EstateDTO;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PaymentCardDTO {

    private Long id;
    private LocalDate createdAt;
    private Set<PaymentDTO> payments;
    private CommunityDTO community;
    private EstateDTO estate;

}
