package pl.sauermann.springboot.server.propertymanagementservice.communities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {

    private CommunityRepository communityRepository;

    private CommunityMapper communityMapper = CommunityMapper.INSTANCE;

    @Autowired
    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public CommunityDTO saveNewCommunity(CommunityDTO CommunityDTO) {
        Community community = communityMapper.communityDTOToCommunity(CommunityDTO);
        Community savedCommunity = communityRepository.save(community);
        return communityMapper.communityToCommunityDTO(savedCommunity);
    }

    @Override
    public CommunityDTO changeCommunityById(Long id, CommunityDTO CommunityDTO) {
        Community community = communityMapper.communityDTOToCommunity(CommunityDTO);
        Community communityById = communityRepository.findById(id).orElseThrow(() -> new RuntimeException("Community with id" + id + "not exist"));
        communityById.setPaymentCards(community.getPaymentCards());
        communityById.setEstates(community.getEstates());
        communityById.setAddress(community.getAddress());
        communityById.setName(community.getName());
        return communityMapper.communityToCommunityDTO(communityRepository.save(communityById));
    }

    @Override
    public void deleteCommunityById(Long id) {
        communityRepository.deleteById(id);
    }

    @Override
    public CommunityDTO findCommunityById(Long id) {
        Community communityById = communityRepository.findById(id).orElseThrow(() -> new RuntimeException("Community with id" + id + "not exist"));
        return communityMapper.communityToCommunityDTO(communityById);
    }
}
