package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.openWeather.City;
import fr.ensim.interop.introrest.model.openWeather.OpenWeather;
import fr.ensim.interop.introrest.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<OpenWeather> weather(
            @RequestParam("ville") String ville,
            @RequestParam(value = "nextDays",defaultValue = "false") Boolean nextDays) {
        City city = weatherService.getCity(ville);
        if(city == null){
            return ResponseEntity.notFound().build();
        }
        OpenWeather openWeather = weatherService.getWeather(city.getLat(), city.getLon());
        if(!nextDays)
            openWeather.onlyOneDay();
        return ResponseEntity
                .ok()
                .body(openWeather);
    }
}
