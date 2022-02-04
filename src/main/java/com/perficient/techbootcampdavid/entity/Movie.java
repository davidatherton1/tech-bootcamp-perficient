package com.perficient.techbootcampdavid.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private Long id;
    private String title;
    private String releaseYear;
    private String director;
    private String studioName;
    @ManyToOne
    @JoinColumn(name = "studio_id")
    @JsonBackReference
    private Studio studio;

    public Movie(){

    }

    public Movie(Long id, String title, String releaseYear, String director) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public Movie(Long id, String title, String releaseYear, String director, Studio studio, String studioName) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.studio = studio;
        this.studioName = studioName;
    }


    public Movie(String title, String releaseYear, String director) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }
}
