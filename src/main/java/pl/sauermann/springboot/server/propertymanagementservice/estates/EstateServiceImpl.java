package pl.sauermann.springboot.server.propertymanagementservice.estates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateServiceImpl implements EstateService {

    private EstateRepository estateRepository;

    private EstateMapper estateMapper = EstateMapper.INSTANCE;

    @Autowired
    public EstateServiceImpl(EstateRepository estateRepository) {
        this.estateRepository = estateRepository;
    }

    @Override
    public EstateDTO saveNewEstate(EstateDTO EstateDTO) {
        Estate estate = estateMapper.estateDTOToEstate(EstateDTO);
        Estate savedEstate = estateRepository.save(estate);
        return estateMapper.estateToEstateDTO(savedEstate);
    }

    @Override
    public EstateDTO changeEstateById(Long id, EstateDTO EstateDTO) {
        Estate estate = estateMapper.estateDTOToEstate(EstateDTO);
        Estate estateById = estateRepository.findById(id).orElseThrow(() -> new RuntimeException("Estate with id" + id + "not exist"));
        estateById.setPaymentCard(estate.getPaymentCard());
        estateById.setSize(estate.getSize());
        estateById.setOwners(estate.getOwners());
        estateById.setEstateName(estate.getEstateName());
        estateById.setCommunity(estate.getCommunity());
        estateById.setAddress(estate.getAddress());
        return estateMapper.estateToEstateDTO(estateRepository.save(estateById));
    }

    @Override
    public void deleteEstateById(Long id) {
        estateRepository.deleteById(id);
    }

    @Override
    public EstateDTO findEstateById(Long id) {
        Estate estateById = estateRepository.findById(id).orElseThrow(() -> new RuntimeException("Estate with id" + id + "not exist"));
        return estateMapper.estateToEstateDTO(estateById);
    }
}
