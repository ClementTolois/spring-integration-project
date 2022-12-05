package test.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import java.io.File;
import java.util.HashMap;

public class MovieService implements MessageSelector {

    private final ObjectMapper objectMapper;

    public MovieService() {
        objectMapper = new ObjectMapper();
    }

    public boolean accept(Message<?> msg) {
        File inputFile = (File) msg.getPayload();

        // Try to parse the JSON file into a Map with keys and values we want to use
        try {
            HashMap<String, Object> movieJson = objectMapper.readValue(inputFile, HashMap.class);

            // Check if the movie has a title and rating as keys (filtering conditions)
            if (movieJson.get("title") == null || movieJson.get("rating") == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}