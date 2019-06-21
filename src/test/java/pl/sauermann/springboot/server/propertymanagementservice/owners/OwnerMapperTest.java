package pl.sauermann.springboot.server.propertymanagementservice.owners;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerMapperTest {

    OwnerMapper ownerMapper = OwnerMapper.INSTANCE;

    Owner owner;

    OwnerDTO ownerDTO;


    @Before
    public void setUp() throws Exception {
        owner = new Owner();
        owner.setId(1L);

        ownerDTO = new OwnerDTO();
        ownerDTO.setId(1L);
    }

    @Test
    public void ownerToOwnerDTO() {
        OwnerDTO result = ownerMapper.ownerToOwnerDTO(owner);

        assertEquals(ownerDTO, result);
    }

    @Test
    public void ownerDTOToOwner() {
        Owner result = ownerMapper.ownerDTOToOwner(ownerDTO);

        assertEquals(owner, result);
    }
}