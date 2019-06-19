package pl.sauermann.springboot.server.propertymanagementservice.communities;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.Address;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;
import pl.sauermann.springboot.server.propertymanagementservice.estate.Estate;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCard;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "communities")
public class Community extends BaseEntity {

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "community")
    private Set<PaymentCard> paymentCards;

    @OneToMany(mappedBy = "community")
    private Set<Estate> estates;
}
