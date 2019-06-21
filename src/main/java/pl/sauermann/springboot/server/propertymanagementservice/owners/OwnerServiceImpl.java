package pl.sauermann.springboot.server.propertymanagementservice.owners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    private OwnerMapper ownerMapper = OwnerMapper.INSTANCE;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDTO saveNewOwner(OwnerDTO OwnerDTO) {
        Owner owner = ownerMapper.ownerDTOToOwner(OwnerDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return ownerMapper.ownerToOwnerDTO(savedOwner);
    }

    @Override
    public OwnerDTO changeOwnerById(Long id, OwnerDTO OwnerDTO) {
        Owner owner = ownerMapper.ownerDTOToOwner(OwnerDTO);
        Owner ownerById = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner with id" + id + "not exist"));
        ownerById.setAddress(owner.getAddress());
        ownerById.setCommunities(owner.getCommunities());
        ownerById.setCorrespondenceAddress(owner.getCorrespondenceAddress());
        ownerById.setEmail(owner.getEmail());
        ownerById.setEmailNotification(owner.getEmailNotification());
        ownerById.setEstates(owner.getEstates());
        ownerById.setFirstName(owner.getFirstName());
        ownerById.setLastName(owner.getLastName());
        ownerById.setPesel(owner.getPesel());
        ownerById.setPhone(owner.getPhone());
        return ownerMapper.ownerToOwnerDTO(ownerRepository.save(ownerById));
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerDTO findOwnerById(Long id) {
        Owner ownerById = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner with id" + id + "not exist"));
        return ownerMapper.ownerToOwnerDTO(ownerById);
    }
}
