package com.movie.review.controller;

import com.movie.review.entity.Movies;
import com.movie.review.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@CrossOrigin
@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {


    private final MovieService service;

    @GetMapping("/all")
    public ResponseEntity<List<Movies>> allMovies(){
        //System.out.println(service.getAllMovies());
        return new ResponseEntity<List<Movies>>(service.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> singleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(service.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
