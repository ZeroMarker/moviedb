package io.manyfox.movies.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> findAllReviews(){
        return new ResponseEntity<>(reviewService.allReviews(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Review> createReviews(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(reviewService.creatReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
