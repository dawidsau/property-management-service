package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    private PaymentService paymentService;

    private Payment returnPayment;
    private PaymentDTO insertedPayment;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        paymentService = new PaymentServiceImpl(paymentRepository);

        returnPayment = new Payment();
        returnPayment.setTitle("Title");
        returnPayment.setId(1L);

        insertedPayment = new PaymentDTO();
        insertedPayment.setTitle("Title");
        insertedPayment.setId(1L);
    }

    @Test
    public void saveNewPayment() {
        when(paymentRepository.save(any(Payment.class))).thenReturn(returnPayment);

        PaymentDTO result = paymentService.saveNewPayment(insertedPayment);

        assertEquals(returnPayment.getTitle(), result.getTitle());
        assertEquals(returnPayment.getId(), result.getId());
    }

    @Test
    public void changePaymentById() {
        when(paymentRepository.save(any(Payment.class))).thenReturn(returnPayment);
        when(paymentRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnPayment));

        PaymentDTO result = paymentService.changePaymentById(1L, insertedPayment);

        assertEquals(returnPayment.getTitle(), result.getTitle());
        assertEquals(returnPayment.getId(), result.getId());
    }

    @Test
    public void deletePaymentById() {
        paymentService.deletePaymentById(anyLong());

        verify(paymentRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void findPaymentById() {
        when(paymentRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnPayment));

        PaymentDTO result = paymentService.findPaymentById(1L);

        assertEquals(returnPayment.getTitle(), result.getTitle());
        assertEquals(returnPayment.getId(), result.getId());
    }
}