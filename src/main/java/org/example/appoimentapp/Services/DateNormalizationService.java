package org.example.appoimentapp.Services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

@Service
public class DateNormalizationService {
    public String normalizeDate(String datePhrase) {
        LocalDate today = LocalDate.now();

        switch (datePhrase.toLowerCase()) {
            case "today":
                return today.format(DateTimeFormatter.ISO_DATE);
            case "tomorrow":
                return today.plusDays(1).format(DateTimeFormatter.ISO_DATE);
            case "next monday":
                return today.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).format(DateTimeFormatter.ISO_DATE);
            case "next tuesday":
                return today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).format(DateTimeFormatter.ISO_DATE);
            case "next wednesday":
                return today.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).format(DateTimeFormatter.ISO_DATE);
            case "next thursday":
                return today.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).format(DateTimeFormatter.ISO_DATE);
            case "next friday":
                return today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).format(DateTimeFormatter.ISO_DATE);
            case "next week":
                return today.plusWeeks(1).format(DateTimeFormatter.ISO_DATE);
            case "this weekend":
                LocalDate nextSaturday = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                return nextSaturday.format(DateTimeFormatter.ISO_DATE);
            case "in 2 days":
                return today.plusDays(2).format(DateTimeFormatter.ISO_DATE);
            case "in 3 days":
                return today.plusDays(3).format(DateTimeFormatter.ISO_DATE);
            default:
                return "2025-10-10"; // Fallback
        }
    }

}
