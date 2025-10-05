package org.example.appoimentapp.Controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.appoimentapp.Services.*;
import org.example.appoimentapp.model.AppointmentRequest;
import org.example.appoimentapp.model.AppointmentResponse;
import org.example.appoimentapp.model.Entities;
import org.example.appoimentapp.model.NormalizedData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
@Slf4j
public class AppointmentController {
    private final OCRService ocrService;
    private final EntityExtractionService entityExtractionService;
    private final DateNormalizationService dateNormalizationService;
    private final TimeNormalizationService timeNormalizationService;
    private final DepartmentMappingService departmentMappingService;
    private final ValidationService validationService;

    @PostMapping("/parse")
    public ResponseEntity<AppointmentResponse> parseAppointment(
            @ModelAttribute AppointmentRequest request) {

        try {
            log.info("Received appointment request: text={}, image={}",
                    request.getText(),
                    request.getImage() != null ? request.getImage().getOriginalFilename() : "null");

            // Step 1: Extract text (OCR or direct text)
            String extractedText = ocrService.extractText(request);

            // Step 2: Extract entities
            Entities entities = entityExtractionService.extractEntities(extractedText);
            if (validationService.isAmbiguous(entities)) {
                return ResponseEntity.ok(AppointmentResponse.builder()
                        .status("needs_clarification")
                        .message("Ambiguous date, time, or department. Please provide more details.")
                        .build());
            }
            // Step 4: Normalize all entities
            NormalizedData normalizedData = NormalizedData.builder()
                    .date(dateNormalizationService.normalizeDate(entities.getDatePhrase()))
                    .time(timeNormalizationService.normalizeTime(entities.getTimePhrase()))
                    .department(departmentMappingService.normalizeDepartment(entities.getDepartment()))
                    .timezone("Asia/Kolkata")
                    .build();

            // Step 5: Build success response
            AppointmentResponse response = AppointmentResponse.builder()
                    .status("ok")
                    .appointment(normalizedData)
                    .build();

            log.info("Successfully parsed appointment: {}", response);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error processing appointment request", e);
            return ResponseEntity.ok(AppointmentResponse.builder()
                    .status("error")
                    .message("Failed to process request: " + e.getMessage())
                    .build());
        }
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Appointment Parser API is running! ✅");
    }

        }
