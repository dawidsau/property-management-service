package pl.sauermann.springboot.server.propertymanagementservice.estates;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class EstateServiceImplTest {

    @Mock
    private EstateRepository estateRepository;

    private EstateService estateService;

    private Estate returnEstate;
    private EstateDTO insertedEstate;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        estateService = new EstateServiceImpl(estateRepository);

        returnEstate = new Estate();
        returnEstate.setEstateName("Name");
        returnEstate.setId(1L);

        insertedEstate = new EstateDTO();
        insertedEstate.setEstateName("Name");
        insertedEstate.setId(1L);
    }

    @Test
    public void saveNewEstate() {
        when(estateRepository.save(any(Estate.class))).thenReturn(returnEstate);

        EstateDTO result = estateService.saveNewEstate(insertedEstate);

        assertEquals(returnEstate.getEstateName(), result.getEstateName());
        assertEquals(returnEstate.getId(), result.getId());
    }

    @Test
    public void changeEstateById() {
        when(estateRepository.save(any(Estate.class))).thenReturn(returnEstate);
        when(estateRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnEstate));

        EstateDTO result = estateService.changeEstateById(1L, insertedEstate);

        assertEquals(returnEstate.getEstateName(), result.getEstateName());
        assertEquals(returnEstate.getId(), result.getId());
    }

    @Test
    public void deleteEstateById() {
        estateService.deleteEstateById(anyLong());

        verify(estateRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void findEstateById() {
        when(estateRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnEstate));

        EstateDTO result = estateService.findEstateById(1L);

        assertEquals(returnEstate.getEstateName(), result.getEstateName());
        assertEquals(returnEstate.getId(), result.getId());
    }

}