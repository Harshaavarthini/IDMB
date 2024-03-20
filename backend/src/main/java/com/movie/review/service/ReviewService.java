package com.movie.review.service;

import com.movie.review.entity.Movies;
import com.movie.review.entity.Review;
import com.movie.review.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepo repo;

    private final MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = repo.insert(new Review(reviewBody));
        mongoTemplate.update(Movies.class).matching(Criteria.where("imdbId").is(imdbId)).
                apply(new Update().push("reviewIds").value(review)).first();
        return review;
    }
}
