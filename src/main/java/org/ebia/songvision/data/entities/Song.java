package org.ebia.songvision.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity {
    private String name;

    // TODO: Extract an entity
    private String songwriter;

    private double duration;

    // TODO: Extract an entity
    private String genre;

    private String songUrl;

    private String textUrl;

    private String thumbnailUrl;

    public Song() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "duration")
    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Column(name = "genre")
    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "song_url", nullable = false)
    public String getSongUrl() {
        return this.songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    @Column(name = "text_url")
    public String getTextUrl() {
        return this.textUrl;
    }

    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    @Column(name = "thumbnail_url", nullable = false)
    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Column(name = "song_writer", nullable = false)
    public String getSongwriter() {
        return this.songwriter;
    }

    public void setSongwriter(String songwriter) {
        this.songwriter = songwriter;
    }
}
