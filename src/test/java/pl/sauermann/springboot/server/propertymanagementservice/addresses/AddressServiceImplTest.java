package pl.sauermann.springboot.server.propertymanagementservice.addresses;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class AddressServiceImplTest {

    @Mock
    private AddressRepository addressRepository;

    private AddressService addressService;

    private Address returnAddress;
    private AddressDTO insertedAddress;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        addressService = new AddressServiceImpl(addressRepository);

        returnAddress = new Address();
        returnAddress.setCity("Lodz");
        returnAddress.setId(1L);

        insertedAddress = new AddressDTO();
        insertedAddress.setCity("Lodz");
        insertedAddress.setId(1L);
    }

    @Test
    public void saveNewAddress() {
        when(addressRepository.save(any(Address.class))).thenReturn(returnAddress);

        AddressDTO result = addressService.saveNewAddress(insertedAddress);

        assertEquals(returnAddress.getCity(),result.getCity());
        assertEquals(returnAddress.getId(),result.getId());
    }

    @Test
    public void changeAddressById() {
        when(addressRepository.save(any(Address.class))).thenReturn(returnAddress);
        when(addressRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnAddress));

        AddressDTO result = addressService.changeAddressById(1L, insertedAddress);

        assertEquals(returnAddress.getCity(),result.getCity());
        assertEquals(returnAddress.getId(),result.getId());
    }

    @Test
    public void deleteAddressById() {
        addressService.deleteAddressById(anyLong());

        verify(addressRepository,times(1)).deleteById(anyLong());
    }

    @Test
    public void findAddressById() {
        when(addressRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnAddress));

        AddressDTO result = addressService.findAddressById(1L);

        assertEquals(returnAddress.getCity(),result.getCity());
        assertEquals(returnAddress.getId(),result.getId());
    }
}