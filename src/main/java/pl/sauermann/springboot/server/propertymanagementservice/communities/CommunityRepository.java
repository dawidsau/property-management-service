package pl.sauermann.springboot.server.propertymanagementservice.communities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
