package pl.sauermann.springboot.server.propertymanagementservice.payments;

public interface PaymentCardService {

    PaymentCardDTO saveNewPaymentCard(PaymentCardDTO PaymentCardDTO);

    PaymentCardDTO changePaymentCardById(Long id, PaymentCardDTO PaymentCardDTO);

    void deletePaymentCardById(Long id);

    PaymentCardDTO findPaymentCardById(Long id);
}
