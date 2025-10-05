package org.example.appoimentapp;

import org.example.appoimentapp.Services.DateNormalizationService;
import org.example.appoimentapp.Services.EntityExtractionService;
import org.example.appoimentapp.model.AppointmentResponse;
import org.example.appoimentapp.model.Entities;
import org.example.appoimentapp.model.NormalizedData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppoimentAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(AppoimentAppApplication.class, args);
        Entities entities = Entities.builder()
                .datePhrase("next Friday")
                .timePhrase("3pm")
                .department("dentist")
                .confidence(0.85)
                .build();

        NormalizedData normalized = NormalizedData.builder()
                .date("2025-09-26")
                .time("15:00")
                .department("Dentistry")
                .timezone("Asia/Kolkata")
                .build();

        AppointmentResponse response = AppointmentResponse.builder()
                .status("ok")
                .appointment(normalized)
                .build();

        System.out.println("✅ All DTOs created successfully!");
        String text = "Book dentist next Friday at 3pm";

        EntityExtractionService entityService = new EntityExtractionService();
        Entities entities1 = entityService.extractEntities(text);

        DateNormalizationService dateService = new DateNormalizationService();
        String date = dateService.normalizeDate(entities.getDatePhrase());

        System.out.println("Extracted: " + entities);
        System.out.println("Normalized Date: " + date);
        System.out.println("✅ All services created successfully!");


    }

}
