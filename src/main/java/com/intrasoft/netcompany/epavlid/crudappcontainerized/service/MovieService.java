package com.intrasoft.netcompany.epavlid.crudappcontainerized.service;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.entity.Movie;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return new ArrayList<>(movieRepository.findAll());
    }

    public Movie getMovieById(Long id){
        return movieRepository.getReferenceById(id);
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(Long id, Movie movie){
        movieRepository.save(movie);
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }

    public void deleteAllMovies(){
        movieRepository.deleteAll();
    }

}
