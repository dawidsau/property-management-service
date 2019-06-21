package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment paymentDTOToPayment(PaymentDTO paymentDTO);

    PaymentDTO paymentToPaymentDTO(Payment payment);

}
