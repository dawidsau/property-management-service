package pl.sauermann.springboot.server.propertymanagementservice.estates;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.addresses.Address;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;
import pl.sauermann.springboot.server.propertymanagementservice.communities.Community;
import pl.sauermann.springboot.server.propertymanagementservice.owners.Owner;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCard;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "estates")
public class Estate extends BaseEntity {

    private String estateName;

    @Embedded
    private EstateSize size;

    @JoinColumn(name = "address_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @JoinColumn(name = "community_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Community community;

    @OneToMany(mappedBy = "estate")
    private Set<PaymentCard> paymentCard;

    @ManyToMany(mappedBy = "estates")
    private Set<Owner> owners;
}
