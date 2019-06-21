package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardServiceImpl implements PaymentCardService {
    private PaymentCardRepository paymentCardRepository;

    private PaymentCardMapper paymentCardMapper = PaymentCardMapper.INSTANCE;

    @Autowired
    public PaymentCardServiceImpl(PaymentCardRepository paymentCardRepository) {
        this.paymentCardRepository = paymentCardRepository;
    }

    @Override
    public PaymentCardDTO saveNewPaymentCard(PaymentCardDTO PaymentCardDTO) {
        PaymentCard paymentCard = paymentCardMapper.paymentCardDTOToPaymentCard(PaymentCardDTO);
        PaymentCard savedPaymentCard = paymentCardRepository.save(paymentCard);
        return paymentCardMapper.paymentCardToPaymentCardDTO(savedPaymentCard);
    }

    @Override
    public PaymentCardDTO changePaymentCardById(Long id, PaymentCardDTO PaymentCardDTO) {
        PaymentCard paymentCard = paymentCardMapper.paymentCardDTOToPaymentCard(PaymentCardDTO);
        PaymentCard paymentCardById = paymentCardRepository.findById(id).orElseThrow(() -> new RuntimeException("PaymentCard with id" + id + "not exist"));
        paymentCardById.setCommunity(paymentCard.getCommunity());
        paymentCardById.setCreatedAt(paymentCard.getCreatedAt());
        paymentCardById.setEstate(paymentCard.getEstate());
        paymentCardById.setPayments(paymentCard.getPayments());
        return paymentCardMapper.paymentCardToPaymentCardDTO(paymentCardRepository.save(paymentCardById));
    }

    @Override
    public void deletePaymentCardById(Long id) {
        paymentCardRepository.deleteById(id);
    }

    @Override
    public PaymentCardDTO findPaymentCardById(Long id) {
        PaymentCard paymentCardById = paymentCardRepository.findById(id).orElseThrow(() -> new RuntimeException("PaymentCard with id" + id + "not exist"));
        return paymentCardMapper.paymentCardToPaymentCardDTO(paymentCardById);
    }
}
