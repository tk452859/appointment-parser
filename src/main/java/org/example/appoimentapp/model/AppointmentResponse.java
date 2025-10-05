package org.example.appoimentapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentResponse {
    private String status;      // "ok", "needs_clarification"
    private NormalizedData appointment;
    private String message;     // for error/ambiguity messages
}
