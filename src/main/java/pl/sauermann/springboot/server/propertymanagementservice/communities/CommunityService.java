package pl.sauermann.springboot.server.propertymanagementservice.communities;

public interface CommunityService {

    CommunityDTO saveNewCommunity(CommunityDTO CommunityDTO);

    CommunityDTO changeCommunityById(Long id, CommunityDTO CommunityDTO);

    void deleteCommunityById(Long id);

    CommunityDTO findCommunityById(Long id);
}
