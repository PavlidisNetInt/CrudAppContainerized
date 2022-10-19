package com.intrasoft.netcompany.epavlid.crudappcontainerized.controller;

import org.springframework.web.bind.annotation.RestController;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.dto.MovieDto;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Movie REST API endpoint")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Operation(summary = "Get All Movies", description = "Return all movie records")
    @GetMapping("/movies")
    public List<MovieDto> getAllMovies(){
        return movieService.getAllMovies();
    }

    @Operation(summary = "Get Movie by Id", description = "Retrieve Movie record by Id")
    @GetMapping("/movies/{id}")
    public MovieDto getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @Operation(summary = "Add movie", description = "Add new Movie record")
    @PostMapping("/movies")
    public String postMovie(@Valid @RequestBody MovieDto movie){
        movieService.addMovie(movie);
        return "Movie record with title " + movie.getTitle() + " has been created.";
    }

    @Operation(summary = "Update movie", description = "Update Movie record by Id")
    @PutMapping("/movies/{id}")
    public void updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieDto movie){
        movieService.updateMovie(id, movie);
    }

    @Operation(summary = "Delete by Id", description = "Delete Movie record by Id")
    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }

    @Operation(summary = "Delete All", description = "Delete All Movie Records")
    @DeleteMapping("/movies")
    public String deleteAllMovies(){
        movieService.deleteAllMovies();
        return "All movie records have been deleted.";
    }

}
