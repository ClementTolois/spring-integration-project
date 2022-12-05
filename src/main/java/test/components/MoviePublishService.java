package test.components;

import org.springframework.messaging.Message;
import org.springframework.web.client.RestTemplate;
import test.models.Movie;

public class MoviePublishService {
    public void handleMoviePublishing(final Message<?> msg) {
        RestTemplate restTemplate = new RestTemplate();

        Movie movie = (Movie) msg.getPayload();
        try {
            restTemplate.postForObject("http://localhost:8080/movies", movie, Movie.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
