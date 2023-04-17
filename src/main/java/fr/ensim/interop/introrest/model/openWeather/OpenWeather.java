package fr.ensim.interop.introrest.model.openWeather;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class OpenWeather {

    private List<DayTemp> daily;

    public void setDaily(List<DayTemp> daily) {
        this.daily = daily.subList(0,3);
    }

    public void onlyOneDay(){
        this.daily = daily.subList(0,1);
    }

    @Override
    public String toString() {
        return  daily.get(0).toString() ;
    }
}
