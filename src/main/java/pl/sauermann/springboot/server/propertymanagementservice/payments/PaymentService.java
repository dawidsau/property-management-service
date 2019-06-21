package pl.sauermann.springboot.server.propertymanagementservice.payments;

public interface PaymentService {

    PaymentDTO saveNewPayment(PaymentDTO PaymentDTO);

    PaymentDTO changePaymentById(Long id, PaymentDTO PaymentDTO);

    void deletePaymentById(Long id);

    PaymentDTO findPaymentById(Long id);
}
