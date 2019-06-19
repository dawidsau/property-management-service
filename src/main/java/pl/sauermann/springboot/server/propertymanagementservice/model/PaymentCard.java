package pl.sauermann.springboot.server.propertymanagementservice.model;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "payment_cards")
public class PaymentCard extends BaseEntity {

    private LocalDate createdAt;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "paymentCard")
    private Set<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "estate_id")
    private Estate estate;

}
