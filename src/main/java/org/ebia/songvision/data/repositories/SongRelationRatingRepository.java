package org.ebia.songvision.data.repositories;

import org.ebia.songvision.data.entities.SongRelationRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRelationRatingRepository extends JpaRepository<SongRelationRating, String> {
}
