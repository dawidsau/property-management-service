package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    private PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentDTO saveNewPayment(PaymentDTO PaymentDTO) {
        Payment payment = paymentMapper.paymentDTOToPayment(PaymentDTO);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.paymentToPaymentDTO(savedPayment);
    }

    @Override
    public PaymentDTO changePaymentById(Long id, PaymentDTO PaymentDTO) {
        Payment payment = paymentMapper.paymentDTOToPayment(PaymentDTO);
        Payment paymentById = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment with id" + id + "not exist"));
        paymentById.setTitle(payment.getTitle());
        paymentById.setCountingType(payment.getCountingType());
        paymentById.setPaymentCard(payment.getPaymentCard());
        paymentById.setValue(payment.getValue());
        return paymentMapper.paymentToPaymentDTO(paymentRepository.save(paymentById));
    }

    @Override
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public PaymentDTO findPaymentById(Long id) {
        Payment paymentById = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment with id" + id + "not exist"));
        return paymentMapper.paymentToPaymentDTO(paymentById);
    }
}
