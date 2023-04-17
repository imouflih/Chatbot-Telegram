package fr.ensim.interop.introrest.service;

import fr.ensim.interop.introrest.model.openWeather.City;
import fr.ensim.interop.introrest.model.openWeather.OpenWeather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherService {
    @Value("${open.weather.api.token}")
    private String API_KEY;
    @Value("${open.weather.api.url}")
    private String API_URL;


    public OpenWeather getWeather(Double lat, Double longitude) {

        RestTemplate restTemplate = new RestTemplate();
        OpenWeather openWeather = restTemplate.getForObject(API_URL + "data/2.5/onecall?lat={lat}"
                        + "&lon={longitude}&exclude=minutely,hourly,current,alerts&appid="
                        + API_KEY,
                OpenWeather.class, lat, longitude);

        return openWeather;
    }

    public City getCity(String nomVille) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "geo/1.0/direct?q=" + nomVille + "&limit=3&appid=" + API_KEY;
        log.info("Url is : {}", url);
        ResponseEntity<City[]> responseEntity = restTemplate.getForEntity(url, City[].class);
        City[] cities = responseEntity.getBody();
        if(cities.length > 0) {
            City city = cities[0];
            return city;
        }
        return null;
    }
}
