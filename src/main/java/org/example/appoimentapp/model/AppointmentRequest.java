package org.example.appoimentapp.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AppointmentRequest {
    private String text;
    private MultipartFile image;
}
