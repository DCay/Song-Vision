package org.ebia.songvision.data.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "song_relations")
public class SongRelation extends BaseEntity {
    private User user;

    private Song targetSong;

    private Song relatedSong;

    private LocalDateTime createdOn;

    private String description;

    private List<SongRelationRating> ratings;

    public SongRelation() {
    }

    @ManyToOne(targetEntity = User.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, optional = true)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, optional = false)
    public Song getTargetSong() {
        return this.targetSong;
    }

    public void setTargetSong(Song targetSong) {
        this.targetSong = targetSong;
    }

    @ManyToOne(targetEntity = User.class, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, optional = false)
    public Song getRelatedSong() {
        return this.relatedSong;
    }

    public void setRelatedSong(Song relatedSong) {
        this.relatedSong = relatedSong;
    }

    @Column(name = "created_on", nullable = false)
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "relation")
    public List<SongRelationRating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<SongRelationRating> ratings) {
        this.ratings = ratings;
    }
}
