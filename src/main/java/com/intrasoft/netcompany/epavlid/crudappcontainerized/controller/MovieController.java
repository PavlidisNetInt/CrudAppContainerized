package com.intrasoft.netcompany.epavlid.crudappcontainerized.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.entity.Movie;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.service.MovieService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Tag(name = "Movie REST API endpoint")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PostMapping("/movies")
    public String postMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return "Movie record with title " + movie.getTitle() + " has been created.";
    }

    @PutMapping("/movies/{id}")
    public void updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMovieById(@PathVariable Long id){
        return movieService.deleteMovieById(id);
    }

    @DeleteMapping("/movies")
    public String deleteAllMovies(){
        movieService.deleteAllMovies();
        return "All movie records have been deleted.";
    }

}
