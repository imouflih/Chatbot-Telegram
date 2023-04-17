package fr.ensim.interop.introrest.model.openWeather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {

    private String main;
    private String description;

    @Override
    public String toString() {
        return "\nEtat : " +  description + "\n";
    }
}
