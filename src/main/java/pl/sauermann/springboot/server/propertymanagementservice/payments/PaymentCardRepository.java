package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, Long> {
}
