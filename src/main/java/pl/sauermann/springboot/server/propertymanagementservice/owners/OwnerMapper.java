package pl.sauermann.springboot.server.propertymanagementservice.owners;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);


    OwnerDTO ownerToOwnerDTO(Owner owner);

    Owner ownerDTOToOwner(OwnerDTO ownerDTO);
}
