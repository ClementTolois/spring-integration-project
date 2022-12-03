package test.models;

import lombok.Data;

@Data
public class Movie {

    private String title;
    private Integer year;
    private Double rating;
    private String director;
    private String[] actors;
    private String[] genres;

    public String toString() {
        return title;
    }

}
