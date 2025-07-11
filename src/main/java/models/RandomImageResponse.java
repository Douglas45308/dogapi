package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomImageResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

