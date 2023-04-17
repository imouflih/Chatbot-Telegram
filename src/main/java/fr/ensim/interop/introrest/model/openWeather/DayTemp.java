package fr.ensim.interop.introrest.model.openWeather;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DayTemp {
    private Temp temp;
    private Integer pressure;
    private Integer humidity;
    private List<Weather> weather;


    @Override
    public String toString() {
        return ": " + temp +
             ", "+ weather.get(0).toString() ;
    }
}
