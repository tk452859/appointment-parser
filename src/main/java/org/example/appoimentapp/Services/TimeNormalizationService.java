package org.example.appoimentapp.Services;

import org.springframework.stereotype.Service;

@Service
public class TimeNormalizationService {
    public String normalizeTime(String timePhrase) {
        switch (timePhrase.toLowerCase()) {
            case "9am": case "9 am": return "09:00";
            case "10am": case "10 am": return "10:00";
            case "11am": case "11 am": return "11:00";
            case "2pm": case "2 pm": return "14:00";
            case "3pm": case "3 pm": return "15:00";
            case "4pm": case "4 pm": return "16:00";
            case "morning": return "09:00";
            case "afternoon": return "14:00";
            case "evening": return "17:00";
            default: return "15:00";
        }
    }

// Add this to TimeNormalizationService:

}
