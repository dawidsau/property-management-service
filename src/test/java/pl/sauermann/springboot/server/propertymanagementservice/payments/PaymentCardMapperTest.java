package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentCardMapperTest {

    PaymentCardMapper paymentCardMapper = PaymentCardMapper.INSTANCE;

    PaymentCardDTO paymentCardDTO;
    PaymentCard paymentCard;

    @Before
    public void setUp() throws Exception {
        paymentCard = new PaymentCard();
        paymentCard.setId(1L);

        paymentCardDTO = new PaymentCardDTO();
        paymentCardDTO.setId(1L);
    }

    @Test
    public void paymentCardDTOToPaymentCard() {
        PaymentCard result = paymentCardMapper.paymentCardDTOToPaymentCard(paymentCardDTO);

        assertEquals(paymentCard, result);
    }

    @Test
    public void paymentCardToPaymentCardDTO() {

        PaymentCardDTO result = paymentCardMapper.paymentCardToPaymentCardDTO(paymentCard);

        assertEquals(paymentCardDTO, result);
    }
}