package fr.ensim.interop.introrest.model.Movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @Override
    public String toString() {
        return title  + "\nYear : " + year + "\nGenre : " + genre + "\nRésumé : " + plot + "\nimbd Rating : " + imdbRating;
    }
}
