package pl.sauermann.springboot.server.propertymanagementservice.payments;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payments")
public class Payment extends BaseEntity {

    private String title;
    private Double value;

    @Enumerated(EnumType.STRING)
    private CountingType countingType;

    @ManyToOne
    @JoinColumn(name = "payment_card_id")
    private PaymentCard paymentCard;


}
