package pl.sauermann.springboot.server.propertymanagementservice.owners;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
