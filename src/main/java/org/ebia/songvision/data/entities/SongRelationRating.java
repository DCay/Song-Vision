package org.ebia.songvision.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "song_relations_ratings")
public class SongRelationRating extends BaseEntity {
    private User user;

    private SongRelation relation;

    private double similarity;

    private String comment;

    public SongRelationRating() {
    }

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, optional = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(targetEntity = SongRelation.class, cascade = CascadeType.ALL, optional = false)
    public SongRelation getRelation() {
        return this.relation;
    }

    public void setRelation(SongRelation relation) {
        this.relation = relation;
    }

    @Column(name = "similarity", nullable = false)
    public double getSimilarity() {
        return this.similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    @Column(name = "comment", nullable = false)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
