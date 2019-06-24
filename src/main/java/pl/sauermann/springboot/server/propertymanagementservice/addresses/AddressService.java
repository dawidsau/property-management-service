package pl.sauermann.springboot.server.propertymanagementservice.addresses;

public interface AddressService {

    AddressDTO saveNewAddress(AddressDTO addressDTO);

    AddressDTO changeAddressById(Long id, AddressDTO addressDTO);

    void deleteAddressById(Long id);

    AddressDTO findAddressById(Long id);

}
