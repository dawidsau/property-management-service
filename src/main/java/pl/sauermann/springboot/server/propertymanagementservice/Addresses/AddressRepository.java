package pl.sauermann.springboot.server.propertymanagementservice.Addresses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
