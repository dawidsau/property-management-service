package pl.sauermann.springboot.server.propertymanagementservice.estates;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstateMapper {

    EstateMapper INSTANCE = Mappers.getMapper(EstateMapper.class);

    Estate estateDTOToEstate(EstateDTO estateDTO);

    EstateDTO estateToEstateDTO(Estate estate);
}
