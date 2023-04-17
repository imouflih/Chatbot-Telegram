package fr.ensim.interop.introrest.client;

import fr.ensim.interop.introrest.model.Joke.Joke;
import fr.ensim.interop.introrest.model.openWeather.OpenWeather;
import org.springframework.web.client.RestTemplate;

public class ClientRestTest {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		// Test Joke API
		String jokeApiUrl = "https://v2.jokeapi.dev/joke/Any?lang=fr&type=twopart";
		Joke joke = restTemplate.getForObject(jokeApiUrl, Joke.class);
		System.out.println("Joke: " + joke);

		// Test Weather API
		testWeatherAPI(restTemplate);
	}

	public static void testWeatherAPI(RestTemplate restTemplate) {
		// Test Weather API
	}
}
