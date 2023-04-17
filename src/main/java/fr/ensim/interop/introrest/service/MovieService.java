package fr.ensim.interop.introrest.service;

import fr.ensim.interop.introrest.model.Joke.Joke;
import fr.ensim.interop.introrest.model.Movie.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    private final RestTemplate restTemplate;

    @Value("${omdb.api.url}")
    private String omdbApiUrl;

    @Value("${omdb.api.key}")
    private String omdbApiKey;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie() {
        RestTemplate restTemplate = new RestTemplate();
        String url = omdbApiUrl + "&apikey=" + omdbApiKey;
        Movie movie = restTemplate.getForObject(url , Movie.class);
        return movie;
    }
}
