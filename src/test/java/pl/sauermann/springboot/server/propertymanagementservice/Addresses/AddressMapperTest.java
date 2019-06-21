package pl.sauermann.springboot.server.propertymanagementservice.Addresses;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class AddressMapperTest {

    private AddressMapper addressMapper = AddressMapper.INSTANCE;

    private Address address;
    private AddressDTO addressDTO;
    @Before
    public void setUp() throws Exception {
        address = new Address();
        address.setCity("City");
        address.setFlatNo("10");
        address.setStreet("Street");
        address.setStreetNo("1A");
        address.setZipCode("Zip-Code");

        addressDTO = new AddressDTO();
        addressDTO.setCity("City");
        addressDTO.setFlatNo("10");
        addressDTO.setStreet("Street");
        addressDTO.setStreetNo("1A");
        addressDTO.setZipCode("Zip-Code");
    }

    @Test
    public void shouldMapAddressToAddressDTO() {
        AddressDTO result = addressMapper.addressToAddressDTO(address);

        assertThat(result.getCity(),equalTo(addressDTO.getCity()));
        assertThat(result.getFlatNo(),equalTo(addressDTO.getFlatNo()));
        assertThat(result.getStreet(),equalTo(addressDTO.getStreet()));
        assertThat(result.getStreetNo(),equalTo(addressDTO.getStreetNo()));
        assertThat(result.getZipCode(),equalTo(addressDTO.getZipCode()));

    }

    @Test
    public void addressDTOTOAddress() {
        Address result = addressMapper.addressDTOToAddress(addressDTO);

        assertThat(result.getCity(),equalTo(address.getCity()));
        assertThat(result.getFlatNo(),equalTo(address.getFlatNo()));
        assertThat(result.getStreet(),equalTo(address.getStreet()));
        assertThat(result.getStreetNo(),equalTo(address.getStreetNo()));
        assertThat(result.getZipCode(),equalTo(address.getZipCode()));
    }
}