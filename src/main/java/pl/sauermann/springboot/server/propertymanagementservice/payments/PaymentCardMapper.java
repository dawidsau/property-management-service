package pl.sauermann.springboot.server.propertymanagementservice.payments;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentCardMapper {

    PaymentCardMapper INSTANCE = Mappers.getMapper(PaymentCardMapper.class);

    PaymentCard paymentCardDTOToPaymentCard(PaymentCardDTO paymentCardDTO);

    PaymentCardDTO paymentCardToPaymentCardDTO(PaymentCard paymentCard);
}
