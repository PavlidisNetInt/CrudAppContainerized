package com.intrasoft.netcompany.epavlid.crudappcontainerized.service;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.entity.Movie;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.exceptions.ResourceNotFoundException;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return new ArrayList<>(movieRepository.findAll());
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(long id, Movie movie){
        movieRepository.save(movie);
    }

    public ResponseEntity<Map<String, Boolean>> deleteMovieById(long id){
        Movie movie = movieRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Movie with " + id + "does not exist"));
        movieRepository.delete(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public void deleteAllMovies(){
        movieRepository.deleteAll();
    }

}
