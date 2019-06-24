package pl.sauermann.springboot.server.propertymanagementservice.addresses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
