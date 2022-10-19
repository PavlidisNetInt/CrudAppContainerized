package com.intrasoft.netcompany.epavlid.crudappcontainerized.service;

import com.intrasoft.netcompany.epavlid.crudappcontainerized.dto.MovieDto;
import com.intrasoft.netcompany.epavlid.crudappcontainerized.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieDto> getAllMovies(){
        return new ArrayList<>(movieRepository.findAll());
    }

    public MovieDto getMovieById(Long id){
        return movieRepository.getReferenceById(id);
    }

    public void addMovie(MovieDto movie){
        movieRepository.save(movie);
    }

    public void updateMovie(Long id, MovieDto movie){
        movieRepository.save(movie);
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }

    public void deleteAllMovies(){
        movieRepository.deleteAll();
    }

}
