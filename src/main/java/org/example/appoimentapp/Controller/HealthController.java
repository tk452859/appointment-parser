package org.example.appoimentapp.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "service", "Appointment Parser",
                "timestamp", Instant.now().toString(),
                "version", "1.0.0"
        ));
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> home() {
        return ResponseEntity.ok(Map.of(
                "message", "Appointment Parser API is running",
                "endpoints", "/health, /parse (or your main endpoint)",
                "status", "Operational"
        ));
    }

}
