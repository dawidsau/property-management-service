package pl.sauermann.springboot.server.propertymanagementservice.communities;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommunityMapper {

    CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);

    Community communityDTOToCommunity(CommunityDTO communityDTO);

    CommunityDTO communityToCommunityDTO(Community community);
}
