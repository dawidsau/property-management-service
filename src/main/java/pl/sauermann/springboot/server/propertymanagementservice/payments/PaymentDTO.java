package pl.sauermann.springboot.server.propertymanagementservice.payments;

import lombok.Data;

@Data
public class PaymentDTO {

    private Long id;
    private String title;
    private String value;
    private String countingType;
    private PaymentCardDTO paymentCard;

}
