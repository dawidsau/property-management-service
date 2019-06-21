package pl.sauermann.springboot.server.propertymanagementservice.communities;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CommunityServiceImplTest {


    @Mock
    private CommunityRepository communityRepository;

    private CommunityService communityService;

    private Community returnCommunity;
    private CommunityDTO insertedCommunity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        communityService = new CommunityServiceImpl(communityRepository);

        returnCommunity = new Community();
        returnCommunity.setName("Name");
        returnCommunity.setId(1L);

        insertedCommunity = new CommunityDTO();
        insertedCommunity.setName("Name");
        insertedCommunity.setId(1L);
    }

    @Test
    public void saveNewCommunity() {
        when(communityRepository.save(any(Community.class))).thenReturn(returnCommunity);

        CommunityDTO result = communityService.saveNewCommunity(insertedCommunity);

        assertEquals(returnCommunity.getName(), result.getName());
        assertEquals(returnCommunity.getId(), result.getId());
    }

    @Test
    public void changeCommunityById() {
        when(communityRepository.save(any(Community.class))).thenReturn(returnCommunity);
        when(communityRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(returnCommunity));

        CommunityDTO result = communityService.changeCommunityById(1L, insertedCommunity);

        assertEquals(returnCommunity.getName(), result.getName());
        assertEquals(returnCommunity.getId(), result.getId());
    }

    @Test
    public void deleteCommunityById() {
        communityService.deleteCommunityById(anyLong());

        verify(communityRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void findCommunityById() {
        when(communityRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnCommunity));

        CommunityDTO result = communityService.findCommunityById(1L);

        assertEquals(returnCommunity.getName(), result.getName());
        assertEquals(returnCommunity.getId(), result.getId());
    }
}