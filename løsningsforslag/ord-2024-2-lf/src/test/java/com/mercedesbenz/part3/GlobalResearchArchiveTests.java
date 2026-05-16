package com.mercedesbenz.part3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import no.ntnu.tdt4100.part3.ResearchReport;

@SuppressWarnings("unused")
public class GlobalResearchArchiveTests {

    @Test
    void getNumberOfSubmittedResearchReports_should_return_the_correct_number() {
        // After implementing the getNumberOfSubmittedResearchReports
        // uncomment test and remove the assertFalse to run the test
        assertFalse(true);

        // long submittedReports = GlobalResearchArchive.getNumberOfSubmittedResearchReports();
        // assertEquals(0, submittedReports);
        // for(int i = 0; i < 10; i++) {
        // GlobalResearchArchive.submitResearchReport(report(i));
        // }
        // assertEquals(10, GlobalResearchArchive.getNumberOfSubmittedResearchReports());
    }

    private ResearchReport report(int i) {
        return new ResearchReport(UUID.randomUUID(), "Random" + 1, LocalDate.now(), null, new byte[]{});
    }
}
