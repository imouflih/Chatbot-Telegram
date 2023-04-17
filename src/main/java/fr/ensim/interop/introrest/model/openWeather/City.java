package fr.ensim.interop.introrest.model.openWeather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {

    private String name;
    private Double lat;
    private Double lon;
    private String country;
}
