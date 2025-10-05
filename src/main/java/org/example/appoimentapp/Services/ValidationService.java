package org.example.appoimentapp.Services;

import org.example.appoimentapp.model.Entities;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean isValidAppointment(Entities entities) {
        return entities.getDatePhrase() != null &&
                !entities.getDatePhrase().equals("unknown") &&
                entities.getTimePhrase() != null &&
                !entities.getTimePhrase().equals("unknown") &&
                entities.getDepartment() != null &&
                !entities.getDepartment().equals("unknown");
    }

    public boolean isAmbiguous(Entities entities) {
        return !isValidAppointment(entities);
    }
    }
