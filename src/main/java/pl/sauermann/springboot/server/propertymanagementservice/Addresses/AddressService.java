package pl.sauermann.springboot.server.propertymanagementservice.Addresses;

public interface AddressService {

    AddressDTO saveNewAddress(AddressDTO addressDTO);

    AddressDTO changeAddressById(Long id, AddressDTO addressDTO);

    void deleteAddressById(Long id);

    AddressDTO findAddressById(Long id);

}
