package org.example.appoimentapp.Services;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class SystemHealthService {
    public Map<String, Object> getHealthStatus() {
        return Map.of(
                "status", "healthy",
                "timestamp", LocalDateTime.now(),
                "service", "Appointment Parser API",
                "version", "1.0"
        );
    }

}
