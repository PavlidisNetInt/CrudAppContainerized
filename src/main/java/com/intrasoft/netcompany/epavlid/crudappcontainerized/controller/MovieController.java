package com.intrasoft.netcompany.epavlid.crudappcontainerized.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.entity.Movie;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.service.MovieService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Movie REST API endpoint")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    @Operation(summary = "Get All Movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    @Operation(summary = "Get a Movie by Id")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id){
        return movieService.getMovieById(id);
    }

    @PostMapping("/movies")
    @Operation(summary = "Add a new Movie")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PutMapping("/movies/{id}")
    @Operation(summary = "Update a Movie by Id")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable long id,
            @RequestBody Movie movie){
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/movies/{id}")
    @Operation(summary = "Delete a Movie")
    public ResponseEntity<Map<String, Boolean>> deleteMovieById(@PathVariable long id){
        return movieService.deleteMovieById(id);
    }

    @DeleteMapping("/movies")
    @Operation(summary = "Delete all Movies")
    public ResponseEntity<Map<String,Boolean>> deleteAllMovies(){
        return movieService.deleteAllMovies();
    }

}
