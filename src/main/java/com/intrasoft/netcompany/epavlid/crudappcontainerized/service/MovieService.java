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

    public ResponseEntity<Movie> getMovieById(long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with " + id + "does not exist"));
        return ResponseEntity.ok(movie);
    }

    public ResponseEntity<Movie> addMovie(Movie movie){
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    public ResponseEntity<Movie> updateMovie(long id, Movie movieDetails){
        Movie movie = movieRepository.findById(movieDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie does not exist with id :" + movieDetails.getId()));
        movie.setTitle(movieDetails.getTitle());
        movie.setDirector(movieDetails.getDirector());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    public ResponseEntity<Map<String, Boolean>> deleteMovieById(long id){
        Movie movie = movieRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " does not exist"));
        movieRepository.delete(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Map<String,Boolean>> deleteAllMovies(){
        movieRepository.deleteAll();
        Map<String, Boolean> response = new HashMap<>();
        response.put("All Movies have been deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
