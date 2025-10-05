package org.example.appoimentapp.Services;


import lombok.extern.slf4j.Slf4j;
import org.example.appoimentapp.model.Entities;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntityExtractionService {
    public Entities extractEntities(String text) {
        log.info("🔍 Extracting entities from: {}", text);

        return Entities.builder()
                .datePhrase(extractDatePhrase(text))
                .timePhrase(extractTimePhrase(text))
                .department(extractDepartment(text))
                .confidence(calculateConfidence(text))
                .build();
    }

    private String extractDatePhrase(String text) {
        text = text.toLowerCase();

        // Expanded date patterns
        if (text.contains("next friday")) return "next Friday";
        if (text.contains("next monday")) return "next Monday";
        if (text.contains("next week")) return "next week";
        if (text.contains("this weekend")) return "this weekend";
        if (text.contains("tomorrow")) return "tomorrow";
        if (text.contains("today")) return "today";
        if (text.contains("monday")) return "next Monday";
        if (text.contains("tuesday")) return "next Tuesday";
        if (text.contains("wednesday")) return "next Wednesday";
        if (text.contains("thursday")) return "next Thursday";
        if (text.contains("friday")) return "next Friday";
        if (text.contains("in 2 days")) return "in 2 days";
        if (text.contains("in 3 days")) return "in 3 days";

        return "unknown";
    }

    private String extractTimePhrase(String text) {
        text = text.toLowerCase();

        // Expanded time patterns
        if (text.contains("9am") || text.contains("9 am")) return "9am";
        if (text.contains("10am") || text.contains("10 am")) return "10am";
        if (text.contains("11am") || text.contains("11 am")) return "11am";
        if (text.contains("2pm") || text.contains("2 pm")) return "2pm";
        if (text.contains("3pm") || text.contains("3 pm")) return "3pm";
        if (text.contains("4pm") || text.contains("4 pm")) return "4pm";
        if (text.contains("morning")) return "morning";
        if (text.contains("afternoon")) return "afternoon";
        if (text.contains("evening")) return "evening";

        return "unknown";
    }

    private String extractDepartment(String text) {
        text = text.toLowerCase();

        // Expanded department patterns
        if (text.contains("dentist") || text.contains("dental") || text.contains("teeth"))
            return "dentist";
        if (text.contains("doctor") || text.contains("physician") || text.contains("checkup"))
            return "doctor";
        if (text.contains("cardiology") || text.contains("heart")) return "cardiology";
        if (text.contains("dermatology") || text.contains("skin")) return "dermatology";
        if (text.contains("ortho") || text.contains("bone")) return "orthopedics";

        return "unknown";
    }

    private Double calculateConfidence(String text) {
        // Simple confidence scoring
        double score = 0.0;
        if (!extractDatePhrase(text).equals("unknown")) score += 0.4;
        if (!extractTimePhrase(text).equals("unknown")) score += 0.3;
        if (!extractDepartment(text).equals("unknown")) score += 0.3;
        return score;
    }


}
