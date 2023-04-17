package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.Movie.Movie;
import fr.ensim.interop.introrest.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<Movie> movie() {
        Movie movie = movieService.getMovie();
        return ResponseEntity.ok().body(movie);
    }
}
