package pl.sauermann.springboot.server.propertymanagementservice.model;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;

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
