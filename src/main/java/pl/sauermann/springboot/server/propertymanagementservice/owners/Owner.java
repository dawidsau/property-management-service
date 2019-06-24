package pl.sauermann.springboot.server.propertymanagementservice.owners;

import lombok.Data;
import pl.sauermann.springboot.server.propertymanagementservice.addresses.Address;
import pl.sauermann.springboot.server.propertymanagementservice.BaseEntity;
import pl.sauermann.springboot.server.propertymanagementservice.communities.Community;
import pl.sauermann.springboot.server.propertymanagementservice.estates.Estate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "owners")
public class Owner extends BaseEntity {

    private String firstName;
    private String lastName;
    private String pesel;
    private String phone;
    private String email;
    private Boolean emailNotification;

    @JoinColumn(name = "address_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @JoinColumn(name = "correspondence_address_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address correspondenceAddress;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "owners_estates",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "estate_id"))
    private Set<Estate> estates;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "owners_communities",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "community_id"))
    private Set<Community> communities;


}
