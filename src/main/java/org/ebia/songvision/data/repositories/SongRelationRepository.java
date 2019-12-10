package org.ebia.songvision.data.repositories;

import org.ebia.songvision.data.entities.SongRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRelationRepository extends JpaRepository<SongRelation, String> {
    List<SongRelation> findByUserUsername(String username);

    @Query("SELECT sr FROM SongRelation AS sr WHERE sr.targetSong.id = ?1 OR sr.relatedSong.id = ?1")
    List<SongRelation> findBySongId(String songId);
}
