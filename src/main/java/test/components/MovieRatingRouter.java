package test.components;

import test.models.Movie;

public class MovieRatingRouter  {
    public String routeMovieRating (Movie movie) {
        if (movie.getRating() >= 5)
            return "good-movies-object-channel";
        return "bad-movies-object-channel";
    }
}
