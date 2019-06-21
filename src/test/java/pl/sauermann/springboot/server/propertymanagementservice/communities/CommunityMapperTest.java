package pl.sauermann.springboot.server.propertymanagementservice.communities;

import org.assertj.core.util.Sets;
import org.junit.Before;
import org.junit.Test;
import pl.sauermann.springboot.server.propertymanagementservice.Addresses.Address;
import pl.sauermann.springboot.server.propertymanagementservice.Addresses.AddressDTO;
import pl.sauermann.springboot.server.propertymanagementservice.estates.Estate;
import pl.sauermann.springboot.server.propertymanagementservice.estates.EstateDTO;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCard;
import pl.sauermann.springboot.server.propertymanagementservice.payments.PaymentCardDTO;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommunityMapperTest {

    private CommunityMapper addressMapper = CommunityMapper.INSTANCE;

    private Community community;
    private CommunityDTO communityDTO;

    @Before
    public void setUp() throws Exception {
        communityBuilding();
        communityDTOBuilding();
    }

    private void communityDTOBuilding() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("Default address");

        EstateDTO estateDTO = new EstateDTO();
        estateDTO.setId(1L);

        PaymentCardDTO paymentCardDTO = new PaymentCardDTO();
        paymentCardDTO.setId(1L);
        communityDTO = new CommunityDTO();
        communityDTO.setName("Community");
        communityDTO.setAddress(addressDTO);
        communityDTO.setEstates(Sets.newLinkedHashSet(estateDTO));
        communityDTO.setPaymentCards(Sets.newLinkedHashSet(paymentCardDTO));
    }

    private void communityBuilding() {
        Address address = new Address();
        address.setCity("Default address");

        Estate estate = new Estate();
        estate.setId(1L);

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setId(1L);

        community = new Community();
        community.setName("Community");
        community.setAddress(address);
        community.setEstates(Sets.newLinkedHashSet(estate));
        community.setPaymentCards(Sets.newLinkedHashSet(paymentCard));
    }

    @Test
    public void communityDTOToCommunity() {
        Community result = addressMapper.communityDTOToCommunity(communityDTO);

        assertThat(result.getAddress(), equalTo(community.getAddress()));
        assertThat(result.getName(), equalTo(community.getName()));
        assertThat(result.getEstates(), equalTo(community.getEstates()));
        assertThat(result.getPaymentCards(), equalTo(community.getPaymentCards()));
    }


    @Test
    public void communityToCommunityDTO() {
        CommunityDTO result = addressMapper.communityToCommunityDTO(community);

        assertThat(result.getAddress(), equalTo(communityDTO.getAddress()));
        assertThat(result.getName(), equalTo(communityDTO.getName()));
        assertThat(result.getEstates(), equalTo(communityDTO.getEstates()));
        assertThat(result.getPaymentCards(), equalTo(communityDTO.getPaymentCards()));
    }
}