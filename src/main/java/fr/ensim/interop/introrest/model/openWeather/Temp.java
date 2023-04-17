package fr.ensim.interop.introrest.model.openWeather;

import lombok.Getter;

@Getter
public class Temp {

    private Integer day;
    private Integer min;
    private Integer max;

    public void setDay(Integer day) {
        this.day = this.kelvinToCelsius(day);
    }

    public void setMin(Integer min) {
        this.min = this.kelvinToCelsius(min);
    }

    public void setMax(Integer max) {
        this.max = this.kelvinToCelsius(max);
    }

    private Integer kelvinToCelsius(Integer kelvin){
        return kelvin - 273;
    }


    @Override
    public String toString() {
        return ""+ day + "°C" +
                "\nTempérature minimale : " + min +"°C"+
                "\nTempérature maximale : " + max +"°C" ;
    }
}
