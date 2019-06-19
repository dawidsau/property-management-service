package pl.sauermann.springboot.server.propertymanagementservice.estate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {
}
