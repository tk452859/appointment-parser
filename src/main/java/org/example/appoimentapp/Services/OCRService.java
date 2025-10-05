package org.example.appoimentapp.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.appoimentapp.model.AppointmentRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OCRService {
    public String extractText(AppointmentRequest request) {
        if (request.getText() != null && !request.getText().isEmpty()) {
            log.info("Using provided text: {}", request.getText());
            return request.getText();
        }

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            log.info("Processing image file: {}", request.getImage().getOriginalFilename());
            // TODO: Integrate Tesseract OCR
            return "book dentist next Friday at 3pm"; // Mock for now
        }

        throw new IllegalArgumentException("No text or image provided");
    }

}
