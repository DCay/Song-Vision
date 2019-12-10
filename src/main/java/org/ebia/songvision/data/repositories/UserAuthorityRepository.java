package org.ebia.songvision.data.repositories;

import org.ebia.songvision.data.entities.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, String> {
    UserAuthority findByAuthority(String authority);
}
