package pl.sauermann.springboot.server.propertymanagementservice.estates;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {
}
