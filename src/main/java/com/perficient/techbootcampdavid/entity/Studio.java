package com.perficient.techbootcampdavid.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.perficient.techbootcampdavid.entity.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "studio")
public class Studio {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "studio")
    @JsonManagedReference
    private Set<Movie> movies = new HashSet<>();

    public Studio(){

    }

    public Studio(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Studio(Long id, String name, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
