package pl.sauermann.springboot.server.propertymanagementservice.estates;

import org.assertj.core.util.Sets;
import org.junit.Before;
import org.junit.Test;
import pl.sauermann.springboot.server.propertymanagementservice.Addresses.Address;
import pl.sauermann.springboot.server.propertymanagementservice.Addresses.AddressDTO;
import pl.sauermann.springboot.server.propertymanagementservice.communities.Community;
import pl.sauermann.springboot.server.propertymanagementservice.communities.CommunityDTO;
import pl.sauermann.springboot.server.propertymanagementservice.owners.Owner;
import pl.sauermann.springboot.server.propertymanagementservice.owners.OwnerDTO;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCard;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCardDTO;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EstateMapperTest {

    private EstateMapper estateMapper = EstateMapper.INSTANCE;

    private Estate estate;

    private EstateDTO estateDTO;

    @Before
    public void setUp() throws Exception {
        buildingEstate();
        buildingEstateDTO();
    }

    private void buildingEstate() {
        Address address = new Address();
        address.setId(1L);

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setId(1L);

        Community community = new Community();
        community.setId(1L);

        Owner owner = new Owner();
        owner.setId(1L);

        EstateSize estateSize = new EstateSize();
        estateSize.setCommonPart("10");
        estate = new Estate();
        estate.setId(1L);
        estate.setSize(estateSize);
        estate.setAddress(address);
        estate.setOwners(Sets.newLinkedHashSet(owner));
        estate.setCommunity(community);
        estate.setEstateName("Estate");
        estate.setPaymentCard(Sets.newLinkedHashSet(paymentCard));
    }

    private void buildingEstateDTO() {
        AddressDTO address = new AddressDTO();
        address.setId(1L);

        PaymentCardDTO paymentCard = new PaymentCardDTO();
        paymentCard.setId(1L);

        CommunityDTO community = new CommunityDTO();
        community.setId(1L);

        OwnerDTO owner = new OwnerDTO();
        owner.setId(1L);

        EstateSize estateSize = new EstateSize();
        estateSize.setCommonPart("10");

        estateDTO = new EstateDTO();
        estateDTO.setId(1L);
        estateDTO.setSize(estateSize);
        estateDTO.setAddress(address);
        estateDTO.setOwners(Sets.newLinkedHashSet(owner));
        estateDTO.setCommunity(community);
        estateDTO.setEstateName("Estate");
        estateDTO.setPaymentCard(Sets.newLinkedHashSet(paymentCard));
    }

    @Test
    public void estateDTOToEstate() {
        Estate result = estateMapper.estateDTOToEstate(estateDTO);

        assertThat(result, equalTo(estate));
    }

    @Test
    public void estateToEstateDTO() {
        EstateDTO result = estateMapper.estateToEstateDTO(estate);

        assertEquals(estateDTO, result);
    }
}