package no.ntnu.tdt4100.part3;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

/**
* THIS CODE IS SUPPLIED, DO NOT MODIFY
*/
public record ResearchReport(UUID reportId, String name, LocalDate published, Set<ResearchReport> citations, byte[] pdfContent) {
    public void addCitation(ResearchReport report) {
        citations.add(report);
    }
}
