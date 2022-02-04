package com.perficient.techbootcampdavid.service;

import com.perficient.techbootcampdavid.entity.Movie;
import com.perficient.techbootcampdavid.entity.Studio;
import com.perficient.techbootcampdavid.repository.MovieRepository;
import com.perficient.techbootcampdavid.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    StudioRepository studioRepository;

    private final AtomicLong counter = new AtomicLong();

    public List<Movie> getMovies(){
        List<Movie> list = new ArrayList<>();
        movieRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public ResponseEntity<Void> addMovie(String title, String releaseYear, String director, String studio){
        List<Studio> foundStudio = studioRepository.findByName(studio);
        Movie movie = new Movie(counter.incrementAndGet(), title, releaseYear, director, foundStudio.get(0), foundStudio.get(0).getName());
        movieRepository.save(movie);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    public ResponseEntity<Void> deleteMovieById(Long id){
        movieRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
