package com.movie.review.controller;

import com.movie.review.entity.Review;
import com.movie.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin()
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {


    private final ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> postReview(@RequestBody Map<String,String> review){
        return new ResponseEntity<Review>(service.createReview(review.get("reviewBody"), review.get("imdbId")), HttpStatus.CREATED);
    }
}
