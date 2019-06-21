package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PaymentCardServiceImplTest {

    @Mock
    private PaymentCardRepository paymentCardRepository;

    private PaymentCardService paymentCardService;

    private PaymentCard returnPaymentCard;
    private PaymentCardDTO insertedPaymentCard;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        paymentCardService = new PaymentCardServiceImpl(paymentCardRepository);

        returnPaymentCard = new PaymentCard();
        returnPaymentCard.setCreatedAt(LocalDate.now());
        returnPaymentCard.setId(1L);

        insertedPaymentCard = new PaymentCardDTO();
        insertedPaymentCard.setCreatedAt(LocalDate.now());
        insertedPaymentCard.setId(1L);
    }

    @Test
    public void saveNewPaymentCard() {
        when(paymentCardRepository.save(any(PaymentCard.class))).thenReturn(returnPaymentCard);

        PaymentCardDTO result = paymentCardService.saveNewPaymentCard(insertedPaymentCard);

        assertEquals(returnPaymentCard.getCreatedAt(), result.getCreatedAt());
        assertEquals(returnPaymentCard.getId(), result.getId());
    }

    @Test
    public void changePaymentCardById() {
        when(paymentCardRepository.save(any(PaymentCard.class))).thenReturn(returnPaymentCard);
        when(paymentCardRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnPaymentCard));

        PaymentCardDTO result = paymentCardService.changePaymentCardById(1L, insertedPaymentCard);

        assertEquals(returnPaymentCard.getCreatedAt(), result.getCreatedAt());
        assertEquals(returnPaymentCard.getId(), result.getId());
    }

    @Test
    public void deletePaymentCardById() {
        paymentCardService.deletePaymentCardById(anyLong());

        verify(paymentCardRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void findPaymentCardById() {
        when(paymentCardRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnPaymentCard));

        PaymentCardDTO result = paymentCardService.findPaymentCardById(1L);

        assertEquals(returnPaymentCard.getCreatedAt(), result.getCreatedAt());
        assertEquals(returnPaymentCard.getId(), result.getId());
    }
}