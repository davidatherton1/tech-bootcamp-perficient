package com.perficient.techbootcampdavid.controller;

import com.perficient.techbootcampdavid.entity.Movie;
import com.perficient.techbootcampdavid.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public List<Movie> movies(){
        return movieService.getMovies();
    }

    @GetMapping({"/movie/{id}"})
    public Optional<Movie> getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Void> addMovie(@RequestParam(value="title", defaultValue = "No Name") String title,
                                         @RequestParam(value="releaseYear", defaultValue = "No Release Year") String releaseYear,
                                         @RequestParam(value="director", defaultValue = "No Director") String director,
                                         @RequestParam(value="studio", defaultValue = "No Studio") String studio
    ){
        return movieService.addMovie(title, releaseYear, director, studio);
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id){
        return movieService.deleteMovieById(id);
    }



}
