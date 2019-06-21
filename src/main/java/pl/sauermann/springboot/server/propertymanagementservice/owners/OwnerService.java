package pl.sauermann.springboot.server.propertymanagementservice.owners;

public interface OwnerService {

    OwnerDTO saveNewOwner(OwnerDTO OwnerDTO);

    OwnerDTO changeOwnerById(Long id, OwnerDTO OwnerDTO);

    void deleteOwnerById(Long id);

    OwnerDTO findOwnerById(Long id);
}
