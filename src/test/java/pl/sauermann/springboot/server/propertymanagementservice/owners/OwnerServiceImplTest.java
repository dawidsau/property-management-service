package pl.sauermann.springboot.server.propertymanagementservice.owners;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class OwnerServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;

    private OwnerService ownerService;

    private Owner returnOwner;
    private OwnerDTO insertedOwner;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ownerService = new OwnerServiceImpl(ownerRepository);

        returnOwner = new Owner();
        returnOwner.setFirstName("Name");
        returnOwner.setId(1L);

        insertedOwner = new OwnerDTO();
        insertedOwner.setFirstName("Name");
        insertedOwner.setId(1L);
    }

    @Test
    public void saveNewOwner() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(returnOwner);

        OwnerDTO result = ownerService.saveNewOwner(insertedOwner);

        assertEquals(returnOwner.getFirstName(), result.getFirstName());
        assertEquals(returnOwner.getId(), result.getId());
    }

    @Test
    public void changeOwnerById() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(returnOwner);
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnOwner));

        OwnerDTO result = ownerService.changeOwnerById(1L, insertedOwner);

        assertEquals(returnOwner.getFirstName(), result.getFirstName());
        assertEquals(returnOwner.getId(), result.getId());
    }

    @Test
    public void deleteOwnerById() {
        ownerService.deleteOwnerById(anyLong());

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void findOwnerById() {
        when(ownerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnOwner));

        OwnerDTO result = ownerService.findOwnerById(1L);

        assertEquals(returnOwner.getFirstName(), result.getFirstName());
        assertEquals(returnOwner.getId(), result.getId());
    }
}