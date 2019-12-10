package org.ebia.songvision.data.repositories;

import org.ebia.songvision.data.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    @Query("SELECT s FROM Song AS s WHERE s.name LIKE %?1%")
    List<Song> findByQuery(String query);
}
