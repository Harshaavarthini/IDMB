package com.movie.review.service;


import com.movie.review.entity.Movies;
import com.movie.review.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepo repo;
    public List<Movies> getAllMovies(){
        return repo.findAll();
    }
    public Optional<Movies> getMovieByImdbId(String imdb){
        return repo.findByImdbId(imdb);
    }
}

