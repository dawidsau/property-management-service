package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentMapperTest {

    PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    Payment payment;
    PaymentDTO paymentDTO;


    @Before
    public void setUp() throws Exception {
        payment = new Payment();
        payment.setTitle("Payment for bills");

        paymentDTO = new PaymentDTO();
        paymentDTO.setTitle("Payment for bills");


    }

    @Test
    public void paymentDTOToPayment() {
        Payment result = paymentMapper.paymentDTOToPayment(paymentDTO);

        assertEquals(payment,result);
    }

    @Test
    public void paymentToPaymentDTO() {
        PaymentDTO result = paymentMapper.paymentToPaymentDTO(payment);

        assertEquals(paymentDTO,result);
    }
}