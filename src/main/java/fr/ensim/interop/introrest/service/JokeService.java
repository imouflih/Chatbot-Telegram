package fr.ensim.interop.introrest.service;

import fr.ensim.interop.introrest.model.Joke.Joke;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class JokeService {
    @Value("${joke.api.url}")
    private String jokeURL;

    public Joke getJoke(){
        RestTemplate restTemplate = new RestTemplate();
        Joke joke = restTemplate.getForObject(jokeURL , Joke.class);
        joke.setNote(new Random().nextInt(10)+1);
        return joke;
    }
}
