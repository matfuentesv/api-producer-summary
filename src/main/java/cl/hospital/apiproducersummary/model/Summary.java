package cl.hospital.apiproducersummary.model;

import lombok.Data;

@Data
public class Summary {

    private String description;
    private String timestamp;

    public Summary(String description, String timestamp) {
        this.description = description;
        this.timestamp = timestamp;
    }
}
