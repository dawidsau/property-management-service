package pl.sauermann.springboot.server.propertymanagementservice.addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    private AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO saveNewAddress(AddressDTO addressDTO) {
        Address address = addressMapper.addressDTOToAddress(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.addressToAddressDTO(savedAddress);
    }

    @Override
    public AddressDTO changeAddressById(Long id, AddressDTO addressDTO) {
        Address address = addressMapper.addressDTOToAddress(addressDTO);
        Address addressById = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address with id" + id + "not exist"));
        addressById.setCity(address.getCity());
        addressById.setZipCode(address.getZipCode());
        addressById.setStreetNo(address.getStreetNo());
        addressById.setStreet(address.getStreet());
        addressById.setFlatNo(address.getFlatNo());
        return addressMapper.addressToAddressDTO(addressRepository.save(addressById));
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDTO findAddressById(Long id) {
        Address addressById = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address with id" + id + "not exist"));
        return addressMapper.addressToAddressDTO(addressById);
    }
}
