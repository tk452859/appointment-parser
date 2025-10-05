package org.example.appoimentapp.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NormalizedData {
    private String date;        // "2025-09-26"
    private String time;        // "15:00"
    private String department;  // "Dentistry"
    private String timezone;    // "Asia/Kolkata"

}
