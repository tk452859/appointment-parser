package org.example.appoimentapp.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entities {
    private String datePhrase;
    private String timePhrase;
    private String department;
    private Double confidence;

}
