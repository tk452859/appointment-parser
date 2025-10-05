package org.example.appoimentapp.Services;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DepartmentMappingService {
    private static final Map<String, String> DEPARTMENT_MAPPING = Map.of(
            "dentist", "Dentistry",
            "dental", "Dentistry",
            "doctor", "General Medicine",
            "physician", "General Medicine"
    );

    public String normalizeDepartment(String department) {
        return DEPARTMENT_MAPPING.getOrDefault(department.toLowerCase(), "General");
    }

}
