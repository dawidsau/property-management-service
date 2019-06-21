package pl.sauermann.springboot.server.propertymanagementservice.estates;

public interface EstateService {
    
    EstateDTO saveNewEstate(EstateDTO EstateDTO);

    EstateDTO changeEstateById(Long id, EstateDTO EstateDTO);

    void deleteEstateById(Long id);

    EstateDTO findEstateById(Long id);
}
