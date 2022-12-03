package test.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import test.models.Movie;

public class MovieService implements MessageSelector {

    private final ObjectMapper objectMapper;

    public MovieService() {
        objectMapper = new ObjectMapper();
    }

    public boolean accept(Message<?> msg) {
        /* check if msg is a valid json object */
        try {
            objectMapper.readValue(msg.getPayload().toString(), Movie.class);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}