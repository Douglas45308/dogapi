package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BreedImagesResponse {
    @JsonProperty("message")
    private List<String> message;

    @JsonProperty("status")
    private String status;

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
